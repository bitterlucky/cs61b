package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque{
    Comparator<T> c;
    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
    }
    public T max() {
        T maxElement = (T)get(0);
        for (int i = 0; i < size(); i++) {
            T thisElement = (T)get(i);
            if (c.compare(maxElement, thisElement) < 0) {
                maxElement = thisElement;
            }
        }
        return maxElement;
    }
    public T max(Comparator<T> c) {
        return new MaxArrayDeque<T>(c).max();
    }
}
