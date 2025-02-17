package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private class Node {
        T item;
        Node preNode;
        Node nextNode;
        public Node(T item) {
            this.item = item;
        }
        public Node(T item, Node preNode, Node nextNode) {
            this.item = item;
            this.preNode = preNode;
            this.nextNode = nextNode;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.preNode = sentinel;
        sentinel.nextNode = sentinel;
        size = 0;
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelp(index, sentinel.nextNode);
    }
    private T getRecursiveHelp(int index, Node temp) {
        if (index == 0) {
            return temp.item;
        } else {
            return getRecursiveHelp(index - 1, temp.nextNode);
        }
    }

    @Override
    public void addFirst(T item) {
        Node node = new Node(item, sentinel, sentinel.nextNode);
        sentinel.nextNode.preNode = node;
        sentinel.nextNode = node;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(item, sentinel.preNode, sentinel);
        sentinel.preNode.nextNode = node;
        sentinel.preNode = node;
        size++;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node temp = sentinel.nextNode;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.nextNode;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node node = sentinel.nextNode;
        sentinel.nextNode.nextNode.preNode = sentinel;
        sentinel.nextNode = sentinel.nextNode.nextNode;
        size--;
        return node.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node node = sentinel.preNode;
        size--;
        sentinel.preNode.preNode.nextNode = sentinel;
        sentinel.preNode = sentinel.preNode.preNode;
        return node.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node temp = sentinel.nextNode;
        for (int i = 0; i < index; i++) {
            temp = temp.nextNode;
        }
        return temp.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
//        if (((LinkedListDeque<?>) o).size() != this.size()) {
//            return false;
//        }
//        for (int i = 0; i < size; i++) {
//            if (get(i) != ((LinkedListDeque<?>) o).get(i)) {
//                return false;
//            }
//        }
//        return true;
        if (((LinkedListDeque<?>) o).size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(((LinkedListDeque<?>) o).get(i))) {
                return false;
            }
        }
        return true;
    }
    private class LinkedListDequeIterator implements Iterator<T> {
        private int wizPos;
        public LinkedListDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }
}
