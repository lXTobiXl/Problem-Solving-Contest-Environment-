package JSPSide;

import java.util.Comparator;
import java.util.HashMap;

public class Team {
    private String teamName;
    private int timePenality;
    private int countAcceptedSolutions;
    private HashMap<Character,Problem> problems;
    private int cntP[] = new int[255];
    private int timeP[] = new int[255];
    private boolean stateP[] = new boolean[255];

    public Team(String temeName){
        this.teamName = temeName;
        problems = new HashMap<>();
    }

    public void addProblem(char problemId, boolean status, int time){
        if(stateP[(int)problemId])
            return;

        if(status){
            ++countAcceptedSolutions;
            timeP[(int)problemId] = cntP[(int)problemId] * 20 + time;
            stateP[(int)problemId] = true;
            timePenality += timeP[(int)problemId];
        }

        ++cntP[(int)problemId];
        problems.put(problemId, new Problem(cntP[(int)problemId], status));
    }

    public static Comparator<Team> TeamsComprator = new Comparator<Team>() {

        public int compare(Team s1, Team s2) {
            int s1AC = s1.getCountAcceptedSolutions();
            int s2AC = s2.getCountAcceptedSolutions();
            if(s1AC == s2AC)
                return s1.getTimePenality() - s2.getTimePenality();

            return s2AC - s1AC;
        }
    };

    public String getTeamName() {
        return teamName;
    }

    public int getTimePenality() {
        return timePenality;
    }

    public HashMap<Character, Problem> getProblems() {
        return problems;
    }

    public int getCountAcceptedSolutions() {
        return countAcceptedSolutions;
    }


}
