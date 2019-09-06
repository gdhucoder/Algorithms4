package Ch_2_2;

import Ch_2_1._Example;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-09-05.
 */
public class _MergeSort extends _Example {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
    assert isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo)
      return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi)
        a[k] = aux[i++];
      else if (less(aux[j], aux[i]))
        a[k] = aux[j++];
      else
        a[k] = aux[i++];
    }
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(100);
    sort(a);
    PrintUtil.show(a);
  }
}
