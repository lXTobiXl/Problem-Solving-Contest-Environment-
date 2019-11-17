package plagiarism;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        String codeDir = "C:\\Users\\VGA!Sys\\Desktop\\Try";
        CheatDetector cd = new CheatDetector(codeDir);
        cd.start();
        ArrayList<String> cheated = cd.getCheated();
        System.out.println("chetaers are : ");
        for(int i = 0; i < cheated.size(); ++i)
            System.out.println(cheated.get(i));

        ArrayList<String> probablyCheated = cd.getProblalyCheated();

        System.out.println("probably cheaters are : ");
        for(int i = 0; i < probablyCheated.size(); ++i)
            System.out.println(probablyCheated.get(i));

    }
}
