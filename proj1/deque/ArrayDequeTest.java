package deque;



import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    public void testAddFirstNoResize() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addFirst(10);
        integerArrayDeque.addFirst(20);
        integerArrayDeque.addFirst(30);
        System.out.println();
    }
    @Test
    public void testSize() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addFirst(10);
        integerArrayDeque.addFirst(20);
        integerArrayDeque.addFirst(30);
        assertEquals(integerArrayDeque.size(), 3);
    }
    @Test
    public void testAddFirstHavingResize() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addFirst(10);
        integerArrayDeque.addFirst(20);
        integerArrayDeque.addFirst(30);
        integerArrayDeque.addFirst(40);
        integerArrayDeque.addFirst(50);
        integerArrayDeque.addFirst(60);
        integerArrayDeque.addFirst(70);
        integerArrayDeque.addFirst(80);
        integerArrayDeque.addFirst(90);
        integerArrayDeque.addFirst(100);
        integerArrayDeque.addFirst(110);
        integerArrayDeque.addFirst(120);
        System.out.printf("s");

    }
    @Test
    public void testGet() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addFirst(10);
        integerArrayDeque.addFirst(20);
        integerArrayDeque.addFirst(30);
        integerArrayDeque.addFirst(40);
        System.out.println(integerArrayDeque.get(0));
        System.out.println(integerArrayDeque.get(1));
        System.out.println(integerArrayDeque.get(2));
        System.out.println(integerArrayDeque.get(3));
        System.out.println(integerArrayDeque.get(4));
        System.out.println(integerArrayDeque.get(-1));
    }
    @Test
    public void testAddLastHavingResize() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addLast(10);
        integerArrayDeque.addLast(20);
        integerArrayDeque.addLast(30);
        integerArrayDeque.addLast(40);
        integerArrayDeque.addLast(50);
        integerArrayDeque.addLast(60);
        integerArrayDeque.addLast(70);
        integerArrayDeque.addLast(80);
        integerArrayDeque.addLast(90);
        integerArrayDeque.addLast(100);
        integerArrayDeque.addLast(110);
        integerArrayDeque.addLast(120);
        System.out.println();
    }
    @Test
    public void testAddLastNoResize() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addLast(10);
        integerArrayDeque.addLast(20);
        integerArrayDeque.addLast(30);
        integerArrayDeque.addLast(40);
        System.out.println();
    }
    @Test
    public void testPrintDeque() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.addFirst(10);
        integerArrayDeque.addFirst(20);
        integerArrayDeque.addFirst(30);
        integerArrayDeque.addFirst(40);
        integerArrayDeque.addFirst(50);
        integerArrayDeque.addFirst(60);
        integerArrayDeque.addFirst(70);
        integerArrayDeque.addFirst(80);
        integerArrayDeque.addFirst(90);
        integerArrayDeque.addFirst(100);
        integerArrayDeque.addFirst(110);
        integerArrayDeque.addFirst(120);
        integerArrayDeque.printDeque();
    }
    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addFirst(i);
        }
        for (int i = 0; i < 25; i++) {
            integerArrayDeque.removeFirst();
        }
        System.out.println();



    }
    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addLast(i);
        }
        for (int i = 0; i < 25; i++) {
            integerArrayDeque.removeLast();
        }
        System.out.println();



    }
    @Test
    public void testIterator() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addLast(i);
        }
        Iterator<Integer> iterator = integerArrayDeque.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next + " ");
        }
    }
    @Test
    public void testEquals() {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque.addLast(i);
        }
        ArrayDeque<Integer> integerArrayDeque1 = new ArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            integerArrayDeque1.addLast(i);
        }
        System.out.println(integerArrayDeque.equals(integerArrayDeque1));
    }
}
