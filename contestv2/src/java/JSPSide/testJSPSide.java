package JSPSide;

import java.util.*;

public class testJSPSide {

    public static void printHashMap(HashMap<Character, Problem> hsh){
        Set<Map.Entry<Character, Problem>> hshUni = hsh.entrySet();
        Iterator<Map.Entry<Character, Problem>> HMIterator = hshUni.iterator();
        while (HMIterator.hasNext()) {
            Map.Entry<Character, Problem> entry = HMIterator.next();
            System.out.print(entry.getKey() + " => ");
            System.out.println("( " + entry.getValue().getTriedCount() + " " +  entry.getValue().getState() + ")");
        }
    }

    public static void printTeam(Team t){
        System.out.println(t.getTeamName());
        System.out.println(t.getTimePenality());
        System.out.println(t.getCountAcceptedSolutions());
        printHashMap(t.getProblems());
        System.out.println("------------------------");
    }
    public static void main(String[] args) {
        Standing s = new Standing();
        System.out.println("number of problems is" + s.getNumberOfProblems());
        Iterator<Team> teamIterator = s.getAllTeams().iterator();
        while (teamIterator.hasNext()) {
            printTeam(teamIterator.next());
        }
    }
}
