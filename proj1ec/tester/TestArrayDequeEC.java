package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
//    @Test
//    public void randomizedTesting() {
//        StringBuilder message = new StringBuilder();
//        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
//        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
//        for (int i = 0; i < 1000; i++) {
//            int num = StdRandom.uniform(4);
//            if (num == 0) {
//                //removeFirst
//                if (studentArrayDeque.size() != 0 && arrayDequeSolution.size() != 0) {
//                    Integer studentArrayDequeFirst = studentArrayDeque.removeFirst();
//                    Integer arrayDequeSolutionFirst = arrayDequeSolution.removeFirst();
//                    message.append("removeFirst()\n");
//                    assertEquals(message.toString().trim(), studentArrayDequeFirst, arrayDequeSolutionFirst);
//                } else {
//                    continue;
//                }
//            } else if (num == 1) {
//                //removeLast
//                if (studentArrayDeque.size() != 0 && arrayDequeSolution.size() != 0) {
//                    Integer studentArrayDequeLast = studentArrayDeque.removeLast();
//                    Integer arrayDequeSolutionLast = arrayDequeSolution.removeLast();
//                    message.append("removeLast()\n");
//                    assertEquals(message.toString().trim(), studentArrayDequeLast, arrayDequeSolutionLast);
//                } else {
//                    continue;
//                }
//            } else if (num == 2) {
//                //addFirst
//                Integer numberBetweenZeroAndOne = StdRandom.uniform(5);
//                studentArrayDeque.addFirst(numberBetweenZeroAndOne);
//                arrayDequeSolution.addFirst(numberBetweenZeroAndOne);
//                message.append("addFirst(" + numberBetweenZeroAndOne +")\n");
//                assertEquals(message.toString().trim(), numberBetweenZeroAndOne, numberBetweenZeroAndOne);
//            } else if (num == 3) {
//                //addLast
//                Integer numberBetweenZeroAndOne = StdRandom.uniform(5);
//                studentArrayDeque.addFirst(numberBetweenZeroAndOne);
//                arrayDequeSolution.addFirst(numberBetweenZeroAndOne);
//                message.append("addLast(" + numberBetweenZeroAndOne + ")\n");
//                assertEquals(message.toString().trim(), numberBetweenZeroAndOne, numberBetweenZeroAndOne);
//            }
//        }
//    }
    @Test
    public void testFailed() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        String msg = "";
        for (int i = 0; i < StdRandom.uniform(0, 1000000); i++) {
            double choice = StdRandom.uniform();
            Integer randVal = StdRandom.uniform(0, 100);
            if (choice < 0.33) {
                student.addLast(randVal);
                solution.addLast(randVal);
                msg += "addLast(" + randVal + ")\n";
            } else if (choice < 0.67) {
                student.addFirst(randVal);
                solution.addFirst(randVal);
                msg += "addFirst(" + randVal + ")\n";
            } else {
                int size = student.size();
                msg += "size()\n";
                if(size > 0){
                    if(randVal <50){
                        msg+="removeFirst()\n";
                        assertEquals(msg,solution.removeFirst(),student.removeFirst());
                    } else {
                        msg +="removeLast()\n";
                        assertEquals(msg,solution.removeLast(),student.removeLast());
                    }
                }
            }
        }
    }

}
