package Ch_2_2;

import Ch_2_1._Example;
import sun.jvm.hotspot.debugger.win32.coff.COMDATSelectionTypes;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-09-11.
 */
public class _MergeBU extends _Example {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz += sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
    assert isSorted(a);
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;
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
    Integer[] a = ArrayGenerator.randomIntArray(10);
    sort(a);
    PrintUtil.show(a);
  }
}
