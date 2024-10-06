package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Iterator;

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
    @Test
    public void testIterator(){
        ArrayDeque<String> testString = new ArrayDeque<>();
        testString.addLast("World");
        testString.addFirst("Hello");
        testString.addLast("!");
        System.out.println(testString.size());
        Iterator<String> stringIterator = testString.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
    }
    @Test
    public void testEquals(){
        ArrayDeque<String> testString1 = new ArrayDeque<>();
        testString1.addLast("World");
        testString1.addFirst("Hello");
        testString1.addLast("!");

        ArrayDeque<String> testString2 = new ArrayDeque<>();
        testString2.addLast("World");
        testString2.addFirst("Hello");
        testString2.addLast("!");
        boolean result = testString1.equals(testString2);
        assertEquals(result, true);
    }

}