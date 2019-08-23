package Ch_2_1;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-23.
 */
public class _InsertionSort extends _Example {

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(10);
    PrintUtil.show(a);
    _InsertionSort.sort(a);
    assert isSorted(a);
    PrintUtil.show(a);
//    5 0 8 3 9 10 7 1 4 2 6
//    0 1 2 3 4 5 6 7 8 9 10
  }

}
