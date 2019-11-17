package clarificationsJSPSide;

public class Clarification {
    private String question;
    private String answer;

    public  Clarification(String q, String ans){
        question = q;
        answer = ans;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
