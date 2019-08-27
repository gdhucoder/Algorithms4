package Ch_2_1;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-25.
 */
public class _ShellSort extends _Example {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N / 3) {
      h = 3 * h + 1;
    }
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }

  /**
   * easy and fast enough
   *
   * @param args
   */
  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(10);
    PrintUtil.show(a);
    _ShellSort.sort(a);
    PrintUtil.show(a);

//    shell time : 0.152 s
//    insertion time : 6.887 s
//    for N = 10000, T= 100,
//    shell is 45.309 times faster than insertion
  }
}
