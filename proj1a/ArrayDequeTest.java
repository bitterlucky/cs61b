import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            integerArrayDeque.addFirst(i);
        }
        integerArrayDeque.printDeque();
    }
    @Test
    public void testAddLastAndPrintDeque() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            integerArrayDeque.addLast(i);
        }
        integerArrayDeque.printDeque();

    }
    @Test
    public void testGetIllegal() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            integerArrayDeque.addLast(i);
        }
        System.out.println(integerArrayDeque.get(16));
    }

    @Test
    public void testGetLegal() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            integerArrayDeque.addLast(i);
        }
        System.out.println(integerArrayDeque.get(14));
    }
    @Test
    public void testRemoveFirstExceedBound() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addLast(i);
        }
        for (int i = 0; i < 18; i++) {
            integerArrayDeque.removeFirst();
        }
        integerArrayDeque.printDeque();
    }
    @Test
    public void testRemoveFirstWithoutExceedBound() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            integerArrayDeque.addLast(i);
        }
        integerArrayDeque.removeFirst();
        integerArrayDeque.removeFirst();
        integerArrayDeque.printDeque();
    }
    @Test
    public void testRemoveLastExceedBound() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addLast(i);
        }
        for (int i = 0; i < 18; i++) {
            integerArrayDeque.removeLast();
        }
        integerArrayDeque.printDeque();
    }
    @Test
    public void testRemoveLastWithoutExceedBound() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            integerArrayDeque.addLast(i);
        }
        integerArrayDeque.removeLast();
        integerArrayDeque.removeLast();
        integerArrayDeque.printDeque();
    }
}
