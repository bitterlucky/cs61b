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
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        Ns.addLast(1000);
        opCounts.addLast(10000);
        Ns.addLast(2000);
        opCounts.addLast(10000);
        Ns.addLast(4000);
        opCounts.addLast(10000);
        Ns.addLast(8000);
        opCounts.addLast(10000);
        Ns.addLast(16000);
        opCounts.addLast(10000);
        Ns.addLast(32000);
        opCounts.addLast(10000);
        Ns.addLast(64000);
        opCounts.addLast(10000);
        Ns.addLast(128000);
        opCounts.addLast(10000);
        for (int i = 0; i < Ns.size(); i++) {
            int num = Ns.get(i);
            SLList<Integer> slList = new SLList<>();
            for (int j = 0; j < num; j++) {
                slList.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < opCounts.get(i); j++) {
                slList.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns,times,opCounts);
    }

}
