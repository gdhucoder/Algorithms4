package Ch_2_2;


import Ch_2_1._Example;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2020/9/13.
 */
public class Ex_2_2_10 extends _Example {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
    assert isSorted(a);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = hi;
    for (int k = lo; k <= mid; k++) {
      aux[k] = a[k];
    }
    for (int k = mid + 1; k <= hi; k++) {
      aux[k] = a[hi - k + mid + 1];
    }
    PrintUtil.show(aux);
    for (int k = lo; k <= hi; k++) {
      if (less(aux[j], aux[i])) a[k] = aux[j--];
      else a[k] = aux[i++];
    }
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(100);
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
  }
}
