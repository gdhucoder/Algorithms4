package Ch_1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.math.BigInteger;

/**
 * Created by HuGuodong on 2019/8/7.
 */

public class Ex_1_4_02 {

  public static int count(int[] a) {
    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          BigInteger sum = BigInteger.valueOf(0);
          sum = sum.add(BigInteger.valueOf(a[i]));
          sum = sum.add(BigInteger.valueOf(a[j]));
          sum = sum.add(BigInteger.valueOf(a[k]));
          if (sum == BigInteger.valueOf(0)) {
            StdOut.printf("%d %d %d\n", a[i], a[j], a[k]);
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
//    /Users/gdhu/projects/Algorithms4/algdata/1Kints.txt
    // input 1Kints.txt
    String file = "algdata/1Kints.txt";
    int[] a = new In(file).readAllInts();
    StdOut.println(count(a));
//    2147483647 -2147483647 0
//    -2147483647 0 2147483647
//    2
  }
}
