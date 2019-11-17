package plagiarism;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CheatDetector {
    private ArrayList<CodeElement> allCodes;
    private ArrayList<String> cheated;
    private ArrayList<String> problalyCheated;
    private String codeDir;
    private final File folder;

    public CheatDetector(String codeDir){
        this.codeDir = codeDir;
        folder = new File(codeDir);
        allCodes = new ArrayList<>();
        cheated = new ArrayList<>();
        problalyCheated = new ArrayList<>();
    }

    private int minimumEditDistance(String code1, String code2) {
        int len1 = code1.length();
        int len2 = code2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        //clear thd dp Array
        for(int i = 0; i <= len1; ++i)
            for(int j = 0; j <= len2; ++j)
                dp[i][j] = 0;

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = code1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = code2.charAt(j);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }

    public void start() {
        try {
            listFilesForFolder(folder);
        }catch (Exception e){
            System.out.println("can't read file content or path is not true");
            e.printStackTrace();
        }

        for(int i = 0; i < allCodes.size(); ++i){
            int mn = (int)1e9;
            for(int j = 0; j < allCodes.size(); ++j){
                if(i == j)
                    continue;
                int MED = minimumEditDistance(allCodes.get(i).getCode(), allCodes.get(j).getCode());
                mn = Math.min(MED, mn);
            }
            double probable = allCodes.get(i).getCode().length() * 0.20;
            if(mn == 0)
                cheated.add(allCodes.get(i).getFileName());
            else if(mn <= probable)
                problalyCheated.add(allCodes.get(i).getFileName());
        }


    }
    private boolean isCodeFile(String path){
        return path.endsWith("cpp") || path.endsWith("java");
    }


    private void listFilesForFolder(final File folder) throws Exception {
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()){
                if(isCodeFile(fileEntry.getName())){
                    CodeElement ce = new CodeElement(fileEntry.getName(), readFile(fileEntry));
                    allCodes.add(ce);
                    //System.out.println(ce.getFileName() + " is a code file");
                }else {
                    //System.out.println(fileEntry.getName() + " not a code file");
                }
            }
        }
    }

    boolean isWhiteSpace(char a){
        return a == ' ' || a == '\n' || a == '\t';
    }

    String readFile(File file) throws Exception{
        String code;
        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                for(int i = 0; i < line.length(); ++i){
                    if(!isWhiteSpace(line.charAt(i)))
                        sb.append(line.charAt(i));
                }
                line = br.readLine();
            }
            code = sb.toString();
        } finally {
            br.close();
        }
        return code;
    }


    public ArrayList<String> getCheated() {
        return cheated;
    }

    public ArrayList<String> getProblalyCheated() {
        return problalyCheated;
    }
}
