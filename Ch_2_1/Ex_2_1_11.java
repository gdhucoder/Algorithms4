package Ch_2_1;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-09-03.
 */
public class Ex_2_1_11 extends _Example {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int[] hs = new int[N / 3];
    for (int i = 0; i < hs.length; i++) {
      hs[i] = 3 * i + 1;
    }
    for (int i = hs.length - 1; i >= 0; i--) {
      int h = hs[i]; // h sort
      for (int j = h; j < N; j++) {
        for (int k = j; k >= h && less(a[k], a[k - h]); k -= h) {
          exch(a, k, k - h);
        }
      }
    }
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(10);
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
//    4 10 8 0 7 2 6 9 1 3 5
//    0 1 2 3 4 5 6 7 8 9 10
  }
}
