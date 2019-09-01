package Ch_2_1;

import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-09-01.
 */
public class Ex_2_1_04 extends _Example {

  public static void sort(Comparable[] a) {
    StdOut.printf("    :");
    PrintUtil.show(a);
    int N = a.length;
    for (int i = 1; i < N; i++) {
      int j = i;
      for (; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
      StdOut.printf("%2d%2d:", i, j);
      PrintUtil.show(a);
    }
    StdOut.printf("    :");
    PrintUtil.show(a);
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(10);
    sort(a);
//       :7 3 5 1 9 6 8 10 2 4 0
//    1 0:3 7 5 1 9 6 8 10 2 4 0
//    2 1:3 5 7 1 9 6 8 10 2 4 0
//    3 0:1 3 5 7 9 6 8 10 2 4 0
//    4 4:1 3 5 7 9 6 8 10 2 4 0
//    5 3:1 3 5 6 7 9 8 10 2 4 0
//    6 5:1 3 5 6 7 8 9 10 2 4 0
//    7 7:1 3 5 6 7 8 9 10 2 4 0
//    8 1:1 2 3 5 6 7 8 9 10 4 0
//    9 3:1 2 3 4 5 6 7 8 9 10 0
//    10 0:0 1 2 3 4 5 6 7 8 9 10
//        :0 1 2 3 4 5 6 7 8 9 10
  }

}
