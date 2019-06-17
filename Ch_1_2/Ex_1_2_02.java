package Ch_1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/17.
 */

public class Ex_1_2_02 {

  public static void intersect(Interval1D[] intervals) {
    int N = intervals.length;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        Interval1D ii = intervals[i];
        Interval1D ij = intervals[j];
        if (ii.intersects(ij)) {
          // print intersect
          StdOut.printf(ii + "\t" + ij + "\n");
        }
      }
    }
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    Interval1D[] intervals = new Interval1D[N];
    for (int i = 0; i < N; i++) {
      intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
    }
    intersect(intervals);
  }
}
