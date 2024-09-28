package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aList = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        aList.addLast(4);
        aList.addLast(5);
        aList.addLast(6);
        buggyAList.addLast(4);
        buggyAList.addLast(5);
        buggyAList.addLast(6);
        assertEquals(aList.removeLast(), buggyAList.removeLast());
    }
    public static void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int brokenSize = broken.size();
                System.out.println("size: " + size +"; broken size: " + brokenSize);
            } else if (operationNumber == 2 && L.size() > 0) {
                int last = L.getLast();
                int brokenLast = broken.getLast();
                System.out.println("get last: " + last + "; get broken last: " + brokenLast);
                last = L.removeLast();
                brokenLast = broken.removeLast();
                System.out.println("remove(" + last + ")" + " broken.remove(" + brokenLast + ")");
            }
        }
    }

    public static void main(String[] args) {
        randomizedTest();
    }


}
