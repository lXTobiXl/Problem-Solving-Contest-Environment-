package plagiarism;

public class CodeElement {

    private String fileName;
    private String code;

    public CodeElement(String fileName, String code){
        this.fileName = fileName;
        this.code = code;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCode() {
        return code;
    }

}
