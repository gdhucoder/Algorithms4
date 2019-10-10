package Ch_2_3;

import Ch_2_1._Example;
import edu.princeton.cs.algs4.StdRandom;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-10-11.
 */
public class _Quick extends _Example {

  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo)
      return;
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
    assert isSorted(a);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];
    while (true) {
      while (less(a[++i], v)) {
        if (i == hi)
          break;
      }
      while (less(v, a[--j])) {
        if (j == lo)
          break;
      }
      if (i >= j) {
        break;
      }
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(10);
    sort(a);
    PrintUtil.show(a);
  }
}
