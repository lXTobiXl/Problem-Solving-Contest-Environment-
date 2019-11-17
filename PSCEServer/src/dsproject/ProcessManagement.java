package dsproject;
import java.io.*;

class State {
    private int verdict;
    public State(int vrd) {
        verdict = vrd;
    }

    int getVerdict() {
        return verdict;
    }

}

public class ProcessManagement {
    private int timeLimit;
    private ProcessBuilder builder;
    private Process pro;
    private String compiledFileName;
    private State retType;
    private String codeDir, inpDir, outDir;

    public ProcessManagement(String name, String codeDir, String inpDir, String outDir, int time) {
        timeLimit = time;
        for (int i = name.length() - 1; i > -1; --i)
            if (name.charAt(i) == '.') {
                compiledFileName = name.substring(0, i);
                break;
            }
        this.inpDir = inpDir;
        this.codeDir = codeDir;
        this.outDir = outDir;
        compileFile(name);
    }

    private void compileFile(String name) {
        try {
            File f = new File(codeDir + compiledFileName + ".exe");
            if(f.exists())
                f.delete();
            //System.out.println("Creating compiled program");

            ProcessBuilder builder = new ProcessBuilder("g++", "-std=c++14", name, "-o", compiledFileName);
            builder.directory(new File(codeDir));

            pro = builder.start();
            while(pro.isAlive())Thread.sleep(1);


            pro.destroy();
            //System.out.println("Finished Compiling");
        } catch (Exception ex) {
            //compile error
            ex.printStackTrace();
        }
    }

    public State run(String inpName, String outName){
        try {

            //System.out.println(codeDir);
            //System.out.println(System.getProperty("user.dir"));
            File f = new File(codeDir + compiledFileName + ".exe");
            if(!f.exists()) {
                //compilation error
                setRetType(new State(0));
                return getRetType();
            }
            //System.out.println("Start running test");
            builder = new ProcessBuilder(codeDir + compiledFileName + ".exe");
            File inpFile = new File(inpDir + inpName);
            if(!inpFile.exists()){
                setRetType(new State(5));
                return getRetType();
            }
            builder.redirectInput(inpFile);
            File outFile = new File(outDir + outName);
            if(outFile.exists())
                outFile.delete();
            builder.redirectOutput(outFile);

            builder.directory(new File(codeDir));
            pro = builder.start();

            Thread.sleep(timeLimit * 3);

            if (pro.isAlive()) {
                pro.destroy();
                //time limite exceded
                setRetType(new State(3));
                return getRetType();
            }


            pro.destroy();

            //System.out.println("exit value: " + pro.exitValue());

            if (pro.exitValue() == 0){
                //run withoutProblems
                setRetType(new State(1));
                return getRetType();
            }else {
                //runtime error
                setRetType(new State(2));
                return getRetType();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            //compilation error
            setRetType(new State(0));
            return getRetType();
        }
    }

    public State getRetType() {
        return retType;
    }

    private void setRetType(State retType) {
        this.retType = retType;
    }
}
