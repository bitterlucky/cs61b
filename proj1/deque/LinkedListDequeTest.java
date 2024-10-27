package deque;



import org.junit.Test;


import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {



        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }
    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);

    }
    @Test
    public void testSize() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        assertEquals(integerLinkedListDeque.size(), 3);
    }
    @Test
    public void testIsEmpty() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        assertEquals(integerLinkedListDeque.isEmpty(), false);
        LinkedListDeque<Integer> integerLinkedListDeque1 = new LinkedListDeque<>();
        assertEquals(integerLinkedListDeque1.isEmpty(), true);
    }
    @Test
    public void testPrintDeque() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        LinkedListDeque<Integer> integerLinkedListDeque1 = new LinkedListDeque<>();
        integerLinkedListDeque.printDeque();
        integerLinkedListDeque1.printDeque();
    }
    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addLast(10);
        integerLinkedListDeque.addLast(20);
        integerLinkedListDeque.addLast(30);
        integerLinkedListDeque.printDeque();
    }
    @Test
    public void testGet() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        integerLinkedListDeque.printDeque();
        System.out.println(integerLinkedListDeque.get(0));
        System.out.println(integerLinkedListDeque.get(1));
        System.out.println(integerLinkedListDeque.get(2));
        System.out.println(integerLinkedListDeque.get(3));
        System.out.println(integerLinkedListDeque.get(-1));

    }
    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        integerLinkedListDeque.printDeque();
        System.out.println(integerLinkedListDeque.removeFirst());
        System.out.println(integerLinkedListDeque.removeFirst());
        integerLinkedListDeque.printDeque();
    }
    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        integerLinkedListDeque.printDeque();
        System.out.println(integerLinkedListDeque.removeLast());
        System.out.println(integerLinkedListDeque.removeLast());
        integerLinkedListDeque.printDeque();
    }
    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        integerLinkedListDeque.printDeque();
        System.out.println(integerLinkedListDeque.getRecursive(0));
        System.out.println(integerLinkedListDeque.getRecursive(1));
        System.out.println(integerLinkedListDeque.getRecursive(2));
        System.out.println(integerLinkedListDeque.getRecursive(3));
        System.out.println(integerLinkedListDeque.getRecursive(-1));
    }
    @Test
    public void testIterator() {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();
        integerLinkedListDeque.addFirst(10);
        integerLinkedListDeque.addFirst(20);
        integerLinkedListDeque.addFirst(30);
        Iterator<Integer> iterator = integerLinkedListDeque.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }
    @Test
    public void testEqual() {
        LinkedListDeque<Integer> integerLinkedListDeque01 = new LinkedListDeque<>();
        LinkedListDeque<Integer> integerLinkedListDeque02 = new LinkedListDeque<>();
        integerLinkedListDeque02.addFirst(10);
        integerLinkedListDeque01.addFirst(10);
        integerLinkedListDeque01.addFirst(20);
        integerLinkedListDeque02.addFirst(20);
        integerLinkedListDeque01.addFirst(30);
        integerLinkedListDeque02.addFirst(30);
        System.out.println(integerLinkedListDeque01.equals(integerLinkedListDeque02));
    }
}
