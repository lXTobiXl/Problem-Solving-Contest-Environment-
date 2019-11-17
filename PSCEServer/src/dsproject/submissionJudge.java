package dsproject;
import java.io.*;

public class submissionJudge{
    private String codeDir, inpDir, outDir, ansDir;
    public submissionJudge(String codeDir, String inpDir, String outDir, String ansDir){
        this.ansDir = ansDir;
        this.codeDir = codeDir;
        this.inpDir = inpDir;
        this.outDir = outDir;
    }
    private void writing(String outName, String outDir, String outPut) {
        try {

            String fullDir = outDir + outName;
            File f = new File(fullDir);
            if(f.exists())
                f.delete();
            //Whatever the file path is.
            File statText = new File(fullDir);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(outPut);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }
    public int run(String codeName ,String inpName, String outName, int timeLimite){

        ProcessManagement p = new ProcessManagement(codeName, codeDir, inpDir, outDir, timeLimite);

        p.run(inpName, outName);
        if(p.getRetType().getVerdict() == 1){
            return p.getRetType().getVerdict();
        }else
            return p.getRetType().getVerdict();

    }
    boolean compareTwoFiles(String ansFileName, String outFileName) throws Exception{
        String everything1, everything2;
        BufferedReader br = new BufferedReader(new FileReader(ansDir + ansFileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything1 = sb.toString();
        } finally {
            br.close();
        }
        br = new BufferedReader(new FileReader(outDir + outFileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything2 = sb.toString();
        } finally {
            br.close();
        }
        return everything1.equals(everything2);
    }
}
