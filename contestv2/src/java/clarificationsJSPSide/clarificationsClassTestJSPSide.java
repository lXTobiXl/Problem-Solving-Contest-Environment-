package clarificationsJSPSide;
import java.util.Iterator;

public class clarificationsClassTestJSPSide {
    public static void main(String[] args) {

        Iterator<Clarification> clarIterator =  DBConClarificationsJSP.getAllClarifications().iterator();
        while (clarIterator.hasNext()) {
            Clarification temp = clarIterator.next();
            System.out.println(temp.getQuestion());
            System.out.println(temp.getAnswer());
            System.out.println("---------------------------");
        }

    }
}
