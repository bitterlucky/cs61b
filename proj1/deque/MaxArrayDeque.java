package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;
    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
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
    public T max(Comparator<T> c) {
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
}
