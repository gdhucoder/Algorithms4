package Ch_2_2;

import Ch_2_1._Example;

/**
 * Created by HuGuodong on 2019-09-12.
 */
public class Ex_2_2_06 {

  public static class MergeSortBU extends _Example {

    public static int arrayAccess = 0;

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
      arrayAccess = 0;
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
      int i = lo, j = mid + 1;
      for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
        arrayAccess += 2;
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
  }

  public static void main(String[] args) {

  }
}
