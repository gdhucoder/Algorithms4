package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/6/14.
 */

public class _AccumulatorTest {

  public static void main(String[] args) {
    int T = 100000000;
    _Accumulator a = new _Accumulator();
    for (int t = 0; t < T; t++) {
      a.addDataValue(StdRandom.uniform());
    }
    StdOut.println(a);
//    Mean (10000 values):0.50307
  }

}
