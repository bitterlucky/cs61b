import org.junit.Test;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
	@Test
	public void testAddFirstWithNoElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
	}
	@Test
	public void testAddFirstWithElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);

	}
	@Test
	public void testAddLastWithNoElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addLast(13);
	}
	@Test
	public void testAddLastWithElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addLast(13);
		linkedListDeque.addLast(14);
		linkedListDeque.addLast(15);
	}
	@Test
	public void testremoveFirstWithElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		System.out.println(linkedListDeque.removeFirst());
		System.out.println(linkedListDeque.removeFirst());
		System.out.println(linkedListDeque.removeFirst());
	}
	@Test
	public void testremoveFirstWithOneElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		System.out.println(linkedListDeque.removeFirst());

	}
	@Test
	public void testremoveFirstWithNoElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		System.out.println(linkedListDeque.removeFirst());

	}
	@Test
	public void testremoveLastWithElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		System.out.println(linkedListDeque.removeLast());
		System.out.println(linkedListDeque.removeLast());
		System.out.println(linkedListDeque.removeLast());
	}
	@Test
	public void testremoveLastWithOneElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		System.out.println(linkedListDeque.removeLast());

	}
	@Test
	public void testremoveLastWithNoElement() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		System.out.println(linkedListDeque.removeLast());

	}
	@Test
	public void testPrintDeque() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		linkedListDeque.printDeque();
	}
	@Test
	public void testGetWithExceedBound() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		System.out.println(linkedListDeque.get(3));
	}
	@Test
	public void testGetWithoutExceedBound() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		System.out.println(linkedListDeque.get(2));
	}
	@Test
	public void testGetRecursiveWithExceedBound() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		System.out.println(linkedListDeque.getRecursive(3));
	}
	@Test
	public void testGetRecursiveWithoutExceedBound() {
		LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
		linkedListDeque.addFirst(13);
		linkedListDeque.addFirst(14);
		linkedListDeque.addFirst(15);
		System.out.println(linkedListDeque.getRecursive(2));
	}
} 