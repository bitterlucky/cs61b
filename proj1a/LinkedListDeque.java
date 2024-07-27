public class LinkedListDeque<T> {
    private int size;
    private Node sentinel;
    public class Node {
        private T item;
        private Node prev;
        private Node next;
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }
    public void addFirst(T item) {
        size += 1;
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
    }
    public void addLast(T item) {
        size += 1;
        Node node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        if (sentinel.next == sentinel) {
            return;
        }
        Node tmp = sentinel;
        while (tmp.next != sentinel) {
            tmp = tmp.next;
            System.out.print(tmp.item);
            System.out.print(" ");
        }
    }
    public T removeFirst() {

        if (sentinel.next == sentinel) {
            return null;
        }
        size -= 1;
        T item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return item;
    }
    public T removeLast() {

        if (sentinel.prev == sentinel) {
            return null;
        }
        size -= 1;
        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return item;
    }
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node tmp = sentinel;
        int i = -1;
        while (i != index) {
            tmp = tmp.next;
            i += 1;
        }
        return tmp.item;
    }
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, sentinel, sentinel);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            return getRecursiveHelp(index, sentinel.next);
        }
    }
    private T getRecursiveHelp(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelp(index - 1, node.next);
        }
    }


}

