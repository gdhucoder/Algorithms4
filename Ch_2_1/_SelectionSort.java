package Ch_2_1;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-22.
 */
public class _SelectionSort extends _Example {

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(10);
    PrintUtil.show(a);
    _SelectionSort.sort(a);
    assert isSorted(a);
    PrintUtil.show(a);
//    8 1 3 9 6 10 4 7 2 0 5
//    0 1 2 3 4 5 6 7 8 9 10
  }
}
