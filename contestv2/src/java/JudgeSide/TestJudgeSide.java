package JudgeSide;

public class TestJudgeSide {
    public static void main(String[] args) {
        //DBConnectionJudgeSide.prepateTable();
        JudgeInterfaceStanding.initStanding(14, 0);


        JudgeInterfaceStanding.addSubmission("tagtag", 1325611, 'A', true);
        JudgeInterfaceStanding.addSubmission("sola", 1551655, 'D', false);
        JudgeInterfaceStanding.addSubmission("solaTeam", 254650, 'D', false);
        JudgeInterfaceStanding.addSubmission("xteam", 38976, 'E', false);
        JudgeInterfaceStanding.addSubmission("team1", 98741356, 'A', true);
        JudgeInterfaceStanding.addSubmission("team2", 1000652, 'E', false);
        JudgeInterfaceStanding.addSubmission("team2", 1000652, 'E', true);
        JudgeInterfaceStanding.addSubmission("team2", 89562, 'C', true);
        JudgeInterfaceStanding.addSubmission("team2", 8954162, 'B', true);
        JudgeInterfaceStanding.addSubmission("team2", 89562, 'K', true);
        JudgeInterfaceStanding.addSubmission("team2", 895162, 'L', true);
        JudgeInterfaceStanding.addSubmission("tagtag", 25563, 'G', false);
        JudgeInterfaceStanding.addSubmission("asd", 11568, 'K', true);
        JudgeInterfaceStanding.addSubmission("tasd", 21565, 'L', true);

        DBConnectionJudgeSide.showAll();
    }
}
