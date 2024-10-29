package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        buggyAList.addLast(4);
        buggyAList.addLast(4);
        buggyAList.addLast(5);
        buggyAList.addLast(5);
        buggyAList.addLast(6);
        buggyAList.addLast(6);
        assertEquals(buggyAList.removeLast(),buggyAList.removeLast());
        assertEquals(buggyAList.removeLast(),buggyAList.removeLast());
        assertEquals(buggyAList.removeLast(),buggyAList.removeLast());
    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggySize = buggyAList.size();
                assertEquals(size, buggySize);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() != 0 && buggyAList.size() != 0) {
                    assertEquals(buggyAList.getLast(), L.getLast());
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() != 0 && buggyAList.size() != 0) {
                    assertEquals(buggyAList.removeLast(), L.removeLast());
                }

            }
        }
    }
}
