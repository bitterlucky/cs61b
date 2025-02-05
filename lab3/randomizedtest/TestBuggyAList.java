package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> integerAListNoResizing = new AListNoResizing<>();
        integerAListNoResizing.addLast(4);
        integerAListNoResizing.addLast(5);
        integerAListNoResizing.addLast(6);
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        buggyAList.addLast(4);
        buggyAList.addLast(5);
        buggyAList.addLast(6);
        assertEquals(buggyAList.removeLast(), integerAListNoResizing.removeLast());
        assertEquals(buggyAList.removeLast(), integerAListNoResizing.removeLast());
        assertEquals(buggyAList.removeLast(), integerAListNoResizing.removeLast());

    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                //addLast

                int randVal = StdRandom.uniform(0, 100);
                System.out.println("addLast + " + randVal);
                aListNoResizing.addLast(randVal);
                buggyAList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                System.out.println("size");
                assertEquals(aListNoResizing.size(), buggyAList.size());

            } else if (operationNumber == 2){
                //removeLast
                System.out.println("removeLast");
                if (aListNoResizing.size() != 0 && buggyAList.size() != 0) {
                    assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
                }

            } else if (operationNumber == 3) {
                //getLast
                System.out.println("getLast");
                if (aListNoResizing.size() != 0 && buggyAList.size() != 0) {
                    assertEquals(aListNoResizing.getLast(), buggyAList.getLast());
                }
            }
        }
    }
//    @Test
//    public void randomizedTest() {
//        AListNoResizing<Integer> L = new AListNoResizing<>();
//
//        int N = 500;
//        for (int i = 0; i < N; i += 1) {
//            int operationNumber = StdRandom.uniform(0, 2);
//            if (operationNumber == 0) {
//                // addLast
//                int randVal = StdRandom.uniform(0, 100);
//                L.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
//            } else if (operationNumber == 1) {
//                // size
//                int size = L.size();
//                System.out.println("size: " + size);
//            }
//        }
//    }
}
