package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/8/6.
 */

public class _ThreeSumClient {

  public static void main(String[] args) {
//    int N = Integer.parseInt(args[0]);
    int N = 2000;
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.uniform(-1000000, 1000000);
    }
    _Stopwatch timer = new _Stopwatch();
    int cnt = _ThreeSum.count(a);
    double time = timer.elapsedTime();
    StdOut.println(N + " : " + cnt + " triples " + time + " seconds");
//    1000 : 64 triples 0.657 seconds
//    2000 : 497 triples 4.614 seconds
  }
}
