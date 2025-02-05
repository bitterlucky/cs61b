package timingtest;
import edu.princeton.cs.algs4.Stopwatch;


/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        opCounts.addLast(1000);
        opCounts.addLast(2000);
        opCounts.addLast(4000);
        opCounts.addLast(8000);
        opCounts.addLast(16000);
        opCounts.addLast(32000);
        opCounts.addLast(64000);
        opCounts.addLast(128000);
        for (int i = 0; i < 8; i++) {
            int frequency = Ns.get(i);
            AList<Integer> temp = new AList<>();
            Stopwatch stopwatch = new Stopwatch();
            for (int j = 0; j < frequency; j++) {
                temp.addLast(10);
            }
            double time = stopwatch.elapsedTime();
            times.addLast(time);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
