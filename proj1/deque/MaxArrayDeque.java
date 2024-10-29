package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }
    public T max() {
        int maxIndex = 0;
        if (size() == 0) {
            return null;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (comparator.compare(get(i), get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }
    public T max(Comparator<T> c) {
        int maxIndex = 0;
        if (size() == 0) {
            return null;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (c.compare(get(i), get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }
}
