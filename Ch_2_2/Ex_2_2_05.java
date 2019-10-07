package Ch_2_2;

import Ch_2_1._Example;
import edu.princeton.cs.algs4.StdOut;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-09-11.
 */
public class Ex_2_2_05 {

  public static class MergeTopDown extends _Example {

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
      StdOut.printf("subarray size: %2d\n", hi - lo + 1);
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
  }

  public static class MergeBU extends _Example {

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
      StdOut.printf("subarray size: %2d\n", hi - lo + 1);
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
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(39);
    MergeTopDown.sort(a);
    PrintUtil.show(a);

    a = ArrayGenerator.randomIntArray(39);
    MergeBU.sort(a);
    PrintUtil.show(a);



//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size: 10
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size: 10
//    subarray size: 20
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size: 10
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size:  2
//    subarray size:  3
//    subarray size:  2
//    subarray size:  5
//    subarray size: 10
//    subarray size: 20
//    subarray size: 40
//    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39
  }
}
