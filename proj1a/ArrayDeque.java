public class ArrayDeque<T> {
    private int size;
    private int maxSize;
    private int nextFirst;
    private int nextLast;
    private T[] arrays;
    private static final double PARSERATE = 0.25;
    public ArrayDeque() {
        size = 0;
        maxSize = 8;
        nextFirst = 0;
        nextLast = 1;
        arrays = (T[]) new Object[maxSize];
    }
    private void shrink() {
        T[] tmpArrays = (T[]) new Object[maxSize / 2];
        int first = parse(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            tmpArrays[i] = arrays[first];
            first = parse(first + 1);
        }
        nextLast = size;
        arrays = (T[]) new Object[maxSize / 2];
        for (int i = 0; i < size; i++) {
            arrays[i] = tmpArrays[i];
        }
        maxSize = maxSize / 2;
        nextFirst = maxSize - 1;

    }
    private void grow() {

        T[] tmpArrays = (T[]) new Object[maxSize * 2];
        int first = parse(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            tmpArrays[i] = arrays[first];
            first = parse(first + 1);
        }

        nextLast = size;
        arrays = (T[]) new Object[maxSize * 2];
        for (int i = 0; i < size; i++) {
            arrays[i] = tmpArrays[i];
        }
        maxSize = maxSize * 2;
        nextFirst = maxSize - 1;
    }
    private int parse(int n) {
        if (n == maxSize) {
            return 0;
        } else if (n == -1) {
            return maxSize - 1;
        } else {
            return n;
        }
    }
    public void addFirst(T item) {
        if (size == maxSize) {
            grow();
        }
        arrays[nextFirst] = item;
        nextFirst--;
        nextFirst = parse(nextFirst);
        size++;

    }
    public void addLast(T item) {
        if (size == maxSize) {
            grow();
        }
        arrays[nextLast] = item;
        nextLast++;
        nextLast = parse(nextLast);
        size++;

    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        int first = parse(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            System.out.print(arrays[first]);
            System.out.print(" ");
            first = parse(first + 1);
        }
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (maxSize >= 16 && size < PARSERATE * maxSize) {
            shrink();
        }
        nextFirst = parse(nextFirst + 1);
        T item = arrays[nextFirst];
        size--;
        return item;

    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (maxSize >= 16 && size < PARSERATE * maxSize) {
            shrink();
        }
        nextLast = parse(nextLast - 1);
        T item = arrays[nextLast];
        size--;
        return item;


    }
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int first = parse(nextFirst + 1);
        for (int i = 0; i < index; i++) {
            first = parse(first + 1);
        }
        return arrays[first];
    }
}
