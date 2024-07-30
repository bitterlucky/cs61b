public class IntList {
    private class IntNode {
        private int item;
        private IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    public IntNode first;
    public IntList() {
        first = new IntNode(10, null);
    }
    public void addLast(int item) {
        IntNode tmp = first;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new IntNode(item, null);
    }
    public void print() {
        IntNode tmp = first;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.print(tmp.item + " ");
        }
    }
    public void skippify() {
        int gap = 2;
        IntNode value = new IntNode(10, null);
        IntNode tmp2 = value;
        IntNode tmp = first.next;
        int cycle = 0;
        tmp2.next = new IntNode(tmp.item, null);
        tmp2 = tmp2.next;
        while (tmp != null) {

            if (cycle == gap) {
                gap += 1;
                cycle = 1;
                tmp2.next = new IntNode(tmp.item, null);
                tmp2 = tmp2.next;
            } else if (cycle != gap) {
                cycle += 1;
            }
            tmp = tmp.next;

        }
        first = value;
    }
    public static void main(String[] args) {
        IntList A = new IntList();
        A.addLast(1);
        A.addLast(2);
        A.addLast(2);
        A.addLast(2);
        A.addLast(3);
        A.print();
        System.out.println();
        A.removeDuplicates();
        A.print();
    }
    public void removeDuplicates() {
        IntNode temp = first.next;
        IntNode value = new IntNode(10,null);
        IntNode temp2 = value;
        int prev = 0;
        while (temp != null) {
            if (temp == first.next) {
                prev = temp.item;
                temp2.next = new IntNode(temp.item, null);
                temp2 = temp2.next;
            } else {
                if (prev != temp.item) {
                    temp2.next = new IntNode(temp.item, null);
                    temp2 = temp2.next;
                    prev = temp.item;
                }
            }
            temp = temp.next;
        }
        first = value;
    }
}
