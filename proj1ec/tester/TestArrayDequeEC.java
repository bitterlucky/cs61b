package tester;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;
public class TestArrayDequeEC {
    @Test
    public void test01() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        //removeFirst, removeLast
        //Your test should NOT cause a NullPointerException. Make sure you never
        // try to remove from an empty ArrayDeque, since Integer x = ad.removeFirst()
        // will cause a NullPointerException.
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        String text = "";
        while (true) {

            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                //addLast
                int randVal = StdRandom.uniform(0, 100);
                studentArrayDeque.addLast(randVal);
                arrayDequeSolution.addLast(randVal);
                text += "addLast(" + randVal + ")\n";
            } else if (operationNumber == 1) {
                //addFirst
                int randVal = StdRandom.uniform(0, 100);
                studentArrayDeque.addFirst(randVal);
                arrayDequeSolution.addFirst(randVal);
                text += "addFirst(" + randVal + ")\n";
            } else if (operationNumber == 2) {
                //removeFirst
                if (studentArrayDeque.size() == 0 || arrayDequeSolution.size() == 0) {
                    continue;
                }
                assertEquals(text+"removeFirst()", studentArrayDeque.removeFirst(), arrayDequeSolution.removeFirst());
                text = text + "removeFirst()\n";
            } else {
                //removeLast
                if (studentArrayDeque.size() == 0 || arrayDequeSolution.size() == 0) {
                    continue;
                }
                assertEquals(text+"removeLast()", studentArrayDeque.removeLast(), arrayDequeSolution.removeLast());
                text = text + "removeLast()\n";
            }

        }
    }
}
