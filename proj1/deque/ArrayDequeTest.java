package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    //add empty ArrayDequeTest

    @Test
    //Add several items and store them correctly
    public void testBasicAddArrayDeque() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertTrue(arrayDeque.isEmpty());
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.addFirst(1);
        //{1,2,3}
        assertEquals(arrayDeque.removeFirst(), Integer.valueOf(1));
        assertEquals(arrayDeque.size(), 2);
        assertFalse(arrayDeque.isEmpty());
    }
    @Test
    public void testRandomAddArrayDeque() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        //add 50 times addFirst or addLast
        int N = 50;
        for (int i = 0; i < N; i ++) {
            int operationNumber = StdRandom.uniform(0, 2);
            int randVal = StdRandom.uniform(0, 100);
            if (operationNumber == 0) {
                arrayDeque.addFirst(randVal);
            }
            else {
                arrayDeque.addLast(randVal);
            }
        }
        assertEquals(N, arrayDeque.size());
        arrayDeque.addLast(24);
        assertEquals(arrayDeque.get(arrayDeque.size() - 1), Integer.valueOf(24));
    }
    //test String
    @Test
    public void testString(){
        ArrayDeque<String> testString = new ArrayDeque<>();
        assertTrue(testString.isEmpty());
        testString.addLast("World");
        testString.addFirst("Hello");
        testString.addLast("!");
        testString.printDeque();
        assertFalse(testString.isEmpty());
    }
    //test add time efficiency

}