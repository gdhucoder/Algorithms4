package Ch_2_1;

import Ch_1_4._Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019-08-24.
 */
public class _SortCompare {

  public static double time(String alg, Double[] a) {
    _Stopwatch timer = new _Stopwatch();
    if (alg.equals("insertion"))
      _InsertionSort.sort(a);
    if (alg.equals("selection"))
      _SelectionSort.sort(a);
    return timer.elapsedTime();
  }


  public static double timeRandomInput(String alg, int N, int T) {
    Double[] a = new Double[N];
    double total = 0.0;
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = StdRandom.uniform();
      }
      total += time(alg, a);
    }
    return total;
  }

  public static void main(String[] args) {
    String alg1 = args[0];
    String alg2 = args[1];
    int N = Integer.parseInt(args[2]);
    int T = Integer.parseInt(args[3]);
    double time1 = timeRandomInput(alg1, N, T);
    double time2 = timeRandomInput(alg2, N, T);
    StdOut.printf("%s time : %.3f s\n", alg1, time1);
    StdOut.printf("%s time : %.3f s\n", alg2, time2);
    StdOut.printf("for N = %d, T= %d,\n"
            + "%s is %.3f times faster than %s\n",
        N, T, alg1, time2 / time1, alg2);
//    insertion time : 27.880 s
//    selection time : 46.829 s
//    for N = 1000, T= 100000,
//    insertion is 1.680 times faster than selection

  }
}
