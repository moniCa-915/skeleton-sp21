package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class MaxArrayDequeTest{
    @Test
    public void testInitiateMax(){
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(cmp);
        maxArrayDeque.addFirst(1);
        maxArrayDeque.addLast(2);
        maxArrayDeque.addLast(3);
        System.out.println(maxArrayDeque.max());
    }
}
