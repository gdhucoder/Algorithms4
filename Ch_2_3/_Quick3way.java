package Ch_2_3;

import Ch_2_1._Example;
import edu.princeton.cs.algs4.StdRandom;
import java.util.concurrent.ConcurrentMap;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-10-14.
 */
public class _Quick3way extends _Example {

  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
    assert isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo)
      return;
    Comparable v = a[lo];
    int lt = lo, i = lo + 1, gt = hi;
    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0)
        exch(a, lt++, i++);
      else if (cmp > 0)
        exch(a, i, gt--);
      else
        i++;
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.duplicateKeysIntArray(10, 3);
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
//    1 0 1 0 2 2 1 1 0 1
//    0 0 0 1 1 1 1 1 2 2
  }
}























