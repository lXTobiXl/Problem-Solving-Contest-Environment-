package problemsJSPSide;

public class Problem {
    private int timelimit;
    private String problem;

    public Problem(int t, String p){
        timelimit = t;
        problem = p;
    }

    public int getTimelimit() {
        return timelimit;
    }

    public String getProblem() {
        return problem;
    }

}
