package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/6/13.
 */

public class Ex_1_1_36 {

  static int[][] hits;

  public static void shuffle(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = i + StdRandom.uniform(N - i);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
    StdOut.println();
  }

  private static void init(int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
  }

  public static void main(String[] args) {
    int M = 10;
    int N = 10000;
    hits = new int[M][M];

    int[] a = new int[M];
    for (int i = 0; i < N; i++) {
      init(a);
      shuffle(a);
      StdOut.print(Arrays.toString(a));
      // statics 统计交换
      for (int j = 0; j < a.length; j++) {
        hits[j][a[j]]++;
      }
    }
    StdOut.printf("\nN = %2d, M = %2d, N/M = %2d", N, M, N / M);
    print(M);

//    j     0	    1	    2	    3	    4	    5	    6	    7	    8	    9
//    -----------------------------------------------------------------
//    0:    11	    8	   11	    6	   12	   11	   13	    7	   10	   11
//    1:    15	   10	    9	    7	    7	    8	   13	   14	   10	    7
//    2:     6	   12	    9	   10	   15	   12	    8	    7	   10	   11
//    3:    11	   10	    5	   12	    6	   13	   13	   13	    4	   13
//    4:    10	    9	   10	    9	    6	   12	   16	    7	    8	   13
//    5:     5	   10	   12	    7	   13	    6	   14	   12	   14	    7
//    6:     7	    9	   11	   15	   12	    7	    6	   11	   16	    6
//    7:    10	    8	   11	   11	   10	   11	    5	   18	   10	    6
//    8:    10	   12	   13	   14	    7	    7	    7	    5	   11	   14
//    9:    15	   12	    9	    9	   12	   13	    5	    6	    7	   12

  }

  private static void print(int m) {
    StdOut.println();
    StdOut.print(" j ");
    for (int i = 0; i < m; i++) {
      StdOut.printf("%5d\t", i);
    }

    StdOut.println("\n-----------------------------------------------------------------");
    for (int i = 0; i < m; i++) {
      StdOut.printf("%2d: ", i);
      for (int j = 0; j < m; j++) {
        StdOut.printf("%5d\t", hits[i][j]);
      }
      StdOut.println();
    }
  }

}
