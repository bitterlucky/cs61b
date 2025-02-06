package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private final static double factor = 0.25;
    private int size;
    private T[] array;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        size = 0;
        array = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }
    @Override
    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }

        array[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = array.length - 1;
        } else {
            nextFirst = nextFirst - 1;

        }
        size = size + 1;
    }

    private void resize(int length) {
        T[] tempArray = (T[]) new Object[length];
        int first;
        if (nextFirst == array.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            tempArray[index++] = array[first];
            if (first == array.length - 1) {
                first = 0;
            } else {
                first = first + 1;
            }
        }
        array = tempArray;
        nextFirst = array.length - 1;
        nextLast = size;
    }

    @Override
    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[nextLast] = item;
        if (nextLast == array.length - 1) {
            nextLast = 0;
        } else {
            nextLast = nextLast + 1;
        }

        size = size + 1;
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

        int first;
        if (nextFirst == array.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(array[first] + " ");
            if (first == array.length - 1) {
                first = 0;
            } else {
                first = first + 1;
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item;
        if (nextFirst == array.length - 1) {
            item = array[0];
            nextFirst = 0;
        } else {
            item = array[nextFirst + 1];
            nextFirst = nextFirst + 1;
        }
        size--;

        if (array.length >= 16 && array.length * factor > size) {
            resize(array.length / 2);
        }
        return item;

    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item;
        if (nextLast == 0) {
            item = array[array.length - 1];
            nextLast = array.length - 1;
        } else {
            item = array[nextLast - 1];
            nextLast = nextLast - 1;
        }
        size--;
        if (array.length >= 16 && array.length * factor > size) {
            resize(array.length / 2);
        }
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int first;
        if (nextFirst == array.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        int i = 0;
        while (i < index) {
            if (first == array.length - 1) {
                first = 0;
            } else {
                first = first + 1;
            }
            i = i + 1;
        }
        return array[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;
        public ArrayDequeIterator() {
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
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque)) {
            return false;
        }

        if (((ArrayDeque<?>) o).size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (get(i) != ((ArrayDeque<?>) o).get(i)) {
                return false;
            }
        }
        return true;
    }
}
