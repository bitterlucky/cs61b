package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void test01() {
        Comparator<Integer> comparator = new Comparator<>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        MaxArrayDeque<Integer> integerMaxArrayDeque = new MaxArrayDeque<>(comparator);


    }
}
