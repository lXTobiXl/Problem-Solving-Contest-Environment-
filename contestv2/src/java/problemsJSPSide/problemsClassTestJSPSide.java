package problemsJSPSide;

import java.util.Iterator;

public class problemsClassTestJSPSide {
    public static void main(String[] args) {

        Iterator<Problem> pIterator =  DBConProblemsJSP.getAllProblems().iterator();
        while (pIterator.hasNext()) {
            Problem temp = pIterator.next();
            System.out.println(temp.getTimelimit());
            System.out.println(temp.getProblem());
            System.out.println("---------------------------");
        }

    }
}
