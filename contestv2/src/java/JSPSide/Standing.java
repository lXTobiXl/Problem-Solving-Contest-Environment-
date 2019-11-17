package JSPSide;

import java.util.ArrayList;
import java.util.Collections;

public class Standing {
    private ArrayList<Team> allTeams;
    DBConnectionJSPSide db;

    public Standing(){
    }

    public static int getNumberOfProblems(){
        return DBConnectionJSPSide.getProblemsCount();
    }

    public ArrayList<Team> getAllTeams() {
        allTeams = DBConnectionJSPSide.getAll();
        if(allTeams == null)
            return null;
        Collections.sort(allTeams, Team.TeamsComprator);

        return allTeams;
    }


    private void addTest(){
        Team tagtaga = new Team("Tagtaga");
        Team legends = new Team("legends");
        tagtaga.addProblem('F', true, 32621);
        tagtaga.addProblem('E', false, 5165);
        tagtaga.addProblem('A', false, 2565465);
        legends.addProblem('C', true, 205616);
        tagtaga.addProblem('A', false, 456465);
        tagtaga.addProblem('A', false, 556984);
        tagtaga.addProblem('A', true, 65710);
        tagtaga.addProblem('A', false, 12597);
        legends.addProblem('C', false, 15565);
        tagtaga.addProblem('D', true, 55616);
        legends.addProblem('A', false, 15123);
        legends.addProblem('A', true, 18000);
        legends.addProblem('G', true, 40000);

        allTeams.add(tagtaga);
        allTeams.add(legends);
    }
}
