package JSPSide;

public class Problem {
    private int triedCount;
    private boolean state;
    private int time;
    public Problem(int tries, boolean state){
        this.triedCount = tries;
        this.state = state;
    }
    public int getTriedCount() {
        return triedCount;
    }

    public boolean getState() {
        return state;
    }

}
