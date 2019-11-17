package JudgeSide;

import java.util.concurrent.TimeUnit;

abstract public class JudgeInterfaceStanding {
    private static long startTime;
    public static void initStanding(int numberOfProblems, long time){
        //step0: mark the contest start time
        startTime = time;
        //step 1: make dataBase connection and make the table ready
        DBConnectionJudgeSide.startConnection();
        DBConnectionJudgeSide.createTableForNumberOfProblems(numberOfProblems);
    }

    public static void addSubmission(String teamName, long time, char problemId, boolean status){
        time = (int) TimeUnit.MILLISECONDS.toMinutes(time - startTime);
        DBConnectionJudgeSide.addSubmission(teamName, time, problemId, status);
    }

}
