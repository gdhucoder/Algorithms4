package Ch_1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/8/10.
 */

/**
 *
 */
public class _TowSumFast {

  public static int count(int[] a) {
    Arrays.sort(a);
    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      if (BinarySearch.indexOf(a, -a[i]) > i) {
        cnt++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    String file = "1Mints.txt";
    int[] a = new In(file).readAllInts();
    StdOut.println("count :" + count(a));
  }
}
