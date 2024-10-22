package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        Node prev;
        Node next;
        T item;
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private int size;
    private Node sentinel;
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public T getRecursive(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }
    private T getRecursiveHelper(int index, Node temp) {
        if (index == 0) {
            return temp.next.item;
        } else {
            return getRecursiveHelper(index - 1, temp.next);
        }
    }
    @Override
    public void addFirst(T item) {
        Node temp = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node temp = new Node(item, sentinel.prev, sentinel);
        size++;
        sentinel.prev.next = temp;
        sentinel.prev = temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size == 0) {
            return;
        }
        Node temp = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.next.item + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return item;
    }

    @Override
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        Node temp = sentinel;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.next.item;
    }
}
