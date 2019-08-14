package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/8/6.
 */

public class _ThreeSumDoublingTest {

  public static double timeTrial(int N) {
    int MAX = 1000000;
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.uniform(-MAX, MAX);
    }
    _Stopwatch timer = new _Stopwatch();
    int cnt = _TowSumFast.count(a);
//    int cnt = _ThreeSumFast.count(a);
    return timer.elapsedTime();
  }

  public static void main(String[] args) {
    for (int N = 250; true; N += N) {
      double time = timeTrial(N);
      StdOut.printf("%7d %5.1f\n", N, time);
    }

    // N^3
//    250   0.0
//    500   0.1
//    1000   0.6
//    2000   3.9
//    4000  22.8
//    8000 184.8
//    16000 1609.8

    // N^2logN
//    250   0.0
//    500   0.0
//    1000   0.0
//    2000   0.1
//    4000   0.6
//    8000   2.5
//    16000   8.6
//    32000  36.0

  }
}
