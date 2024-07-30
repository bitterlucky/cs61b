public class SLList {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}
	}
	private IntNode first;
	public void addFirst(int x) {
		first = new IntNode(x, first);
	}
	public void insert(int item, int position) {
		if (first == null || position == 0) {
			addFirst(item);
		} else {
			IntNode temp = first;
			for (int i = 0; i < position - 1 && temp.next != null; i++) {
				temp = temp.next;
			}
		
			IntNode node = new IntNode(item, temp.next);
			temp.next = node;
				
			}
	}
	public void reverseIter() {
		IntNode prev = null;
        IntNode curr = first;
        while (curr != null) {
            IntNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first = prev;
	}
	public void reverseRecrusion() {
		first = reverseHelper(first, null);
	}
	private IntNode reverseHelper(IntNode current, IntNode prev) {
        if (current == null) {
            return prev;
        }
        IntNode next = current.next;
        current.next = prev;
        return reverseHelper(next, current);
    }
    public static void main(String[] args) {
    	SLList list = new SLList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
    	list.reverseRecrusion();
    	System.out.println("hh");
    }
}