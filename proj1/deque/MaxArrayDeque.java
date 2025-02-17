package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;
    public MaxArrayDeque(Comparator<T> comparator) {
        this.c = comparator;
    }
    public T max() {
        if (size() == 0) {
            return null;
        }
        T maxElement = get(0);
        for (int i = 0; i < size(); i++) {
            T thisElement = get(i);
            if (c.compare(thisElement, maxElement) > 0) {
                maxElement = thisElement;
            }
        }
        return maxElement;
    }
    public T max(Comparator<T> comparator) {
        if (size() == 0) {
            return null;
        }
        T maxElement = get(0);
        for (int i = 0; i < size(); i++) {
            T thisElement = get(i);
            if (comparator.compare(thisElement, maxElement) > 0) {
                maxElement = thisElement;
            }
        }
        return maxElement;
    }
}
