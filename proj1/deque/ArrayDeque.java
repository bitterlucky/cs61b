package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>,Iterable<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] arrays;
    private static final double FACTOR = 0.25;
    public ArrayDeque() {
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        arrays = (T[]) new Object[8];
    }
    @Override
    public void addFirst(T item) {
        if (size == arrays.length) {
            resize(arrays.length * 2);
        }
        arrays[nextFirst] = item;
        nextFirst = parseFirstAndNext(nextFirst - 1);
        size += 1;
    }
    private int parseFirstAndNext(int value) {
        if (value == -1) {
            return arrays.length - 1;
        } else if (value == arrays.length) {
            return 0;
        } else {
            return value;
        }
    }

    private void resize(int capacity) {
        T[] newArrays = (T[]) new Object[capacity];
        int temp = parseFirstAndNext(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            newArrays[i] = arrays[temp];
            temp = parseFirstAndNext(temp + 1);
        }
        arrays = newArrays;
        nextFirst = arrays.length - 1;
        nextLast = size;

    }

    @Override
    public void addLast(T item) {
        if (size == arrays.length) {
            resize(arrays.length * 2);
        }
        arrays[nextLast] = item;
        nextLast = parseFirstAndNext(nextLast + 1);
        size += 1;
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
        int temp = parseFirstAndNext(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            System.out.print(arrays[temp] + " ");
            temp = parseFirstAndNext(temp + 1);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (arrays.length >= 16 && size < arrays.length * FACTOR) {
            resize(arrays.length / 2);
        }
        T item = arrays[parseFirstAndNext(nextFirst + 1)];
        arrays[parseFirstAndNext(nextFirst + 1)] = null;
        size--;
        nextFirst = parseFirstAndNext(nextFirst + 1);
        return item;

    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (arrays.length >= 16 && size < arrays.length * FACTOR) {
            resize(arrays.length / 2);
        }
        T item = arrays[parseFirstAndNext(nextLast - 1)];
        arrays[parseFirstAndNext(nextLast - 1)] = null;
        size--;
        nextLast = parseFirstAndNext(nextLast - 1);
        return item;
    }

    @Override
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        int temp = parseFirstAndNext(nextFirst + 1);
        for (int i = 0; i < index; i++) {
            temp = parseFirstAndNext(temp + 1);
        }
        return arrays[temp];
    }
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (this.size != ((Deque<?>) o).size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(((Deque<?>) o).get(i))) {
                return false;
            }
        }
        return true;
    }
    private class ArrayDequeIterator implements Iterator<T> {
        private int position;
        ArrayDequeIterator() {
            position = 0;
        }
        @Override
        public boolean hasNext() {
            return position != size;
        }

        @Override
        public T next() {
            T returnItem = get(position);
            position += 1;
            return returnItem;
        }
    }
}
