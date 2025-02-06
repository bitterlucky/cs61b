package deque;

import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void removeFirst() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addLast(i);
        }
        System.out.println(integerArrayDeque.removeFirst());
        System.out.println(integerArrayDeque.removeFirst());
        System.out.println(integerArrayDeque.removeFirst());
        System.out.println(integerArrayDeque.removeFirst());
        System.out.println(integerArrayDeque.removeFirst());
    }
}
