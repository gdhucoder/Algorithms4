package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/8/14.
 */

public class Ex_1_4_08 {

  public static int countTwoEqualsSlow(int[] a) {
    int cnt = 0;
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++)
        if (a[i] == a[j])
          cnt++;
    return cnt;
  }

  public static int countTwoEqualsFast(int[] a) {
    int N = a.length;
    int count = 0;
    Arrays.sort(a);
    int dup = 0;
    for (int i = 1; i < N; i++) {
      if (a[i - 1] == a[i]) {
        dup++;
      } else {
        count += dup * (dup + 1) / 2;
        dup = 0;
      }
      if (i == N - 1) {
        count += dup * (dup + 1) / 2;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {4, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4};
    StdOut.printf("slow count : %d\n", countTwoEqualsSlow(a));
    StdOut.printf("fast count : %d\n", countTwoEqualsFast(a));
  }
}
