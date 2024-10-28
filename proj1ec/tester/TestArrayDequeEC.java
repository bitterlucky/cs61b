package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomizedTesting() {
        StringBuilder message = new StringBuilder();
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        for (int i = 0; i < 1000; i++) {
            int num = StdRandom.uniform(4);
            if (num == 0) {
                //removeFirst
                if (studentArrayDeque.size() != 0 && arrayDequeSolution.size() != 0) {
                    Integer studentArrayDequeFirst = studentArrayDeque.removeFirst();
                    Integer arrayDequeSolutionFirst = arrayDequeSolution.removeFirst();
                    message.append("removeFirst()\n");
                    assertEquals(message.toString().trim(), studentArrayDequeFirst, arrayDequeSolutionFirst);
                } else {
                    continue;
                }
            } else if (num == 1) {
                //removeLast
                if (studentArrayDeque.size() != 0 && arrayDequeSolution.size() != 0) {
                    Integer studentArrayDequeLast = studentArrayDeque.removeLast();
                    Integer arrayDequeSolutionLast = arrayDequeSolution.removeLast();
                    message.append("removeLast()\n");
                    assertEquals(message.toString().trim(), studentArrayDequeLast, arrayDequeSolutionLast);
                } else {
                    continue;
                }
            } else if (num == 2) {
                //addFirst
                Integer numberBetweenZeroAndOne = StdRandom.uniform(5);
                studentArrayDeque.addFirst(numberBetweenZeroAndOne);
                arrayDequeSolution.addFirst(numberBetweenZeroAndOne);
                message.append("addFirst(" + numberBetweenZeroAndOne +")\n");
                assertEquals(message.toString().trim(), numberBetweenZeroAndOne, numberBetweenZeroAndOne);
            } else if (num == 3) {
                //addLast
                Integer numberBetweenZeroAndOne = StdRandom.uniform(5);
                studentArrayDeque.addFirst(numberBetweenZeroAndOne);
                arrayDequeSolution.addFirst(numberBetweenZeroAndOne);
                message.append("addLast(" + numberBetweenZeroAndOne + ")\n");
                assertEquals(message.toString().trim(), numberBetweenZeroAndOne, numberBetweenZeroAndOne);
            }
        }
    }

}
