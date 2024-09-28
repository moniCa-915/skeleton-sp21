package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        //create test condition
        AList<Integer> Ns = new AList<>();
        int firstN = 1000;
        for (int i = 0; i < 8; i ++) {
            Ns.addLast(firstN);
            firstN *= 2;
        }
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < 8; i ++) {
            opCounts.addLast(10);

        }        for (int i = 0; i < Ns.size(); i ++) {
            SLList<Integer> test = new SLList<>(); //create an SLLit
            for (int j = 0; j < Ns.get(i); j ++) {
                test.addLast(j);
            }
            Stopwatch sw = new Stopwatch();
            for (int op = 0; op < opCounts.get(i); op ++) {
                int lastOne = test.getLast();
            }
            times.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns, times, opCounts);
    }

}
