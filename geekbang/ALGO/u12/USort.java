package geekbang.ALGO.u12;

import static geekbang.ALGO.u12.USort.Sort.MergeSort;

import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/3/7.
 */

public class USort {

  public static class Sort {

    public static void MergeSort(int[] a) {
      int n = a.length;
      int[] aux = new int[n];
      sort(a, aux, 0, n - 1);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
      if (lo >= hi) {
        return;
      }
      int mid = lo + (hi - lo) / 2;
      sort(a, aux, lo, mid);
      sort(a, aux, mid + 1, hi);
      merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
      // 输出标志
      StdOut.printf("%d, %d, %d\n", lo, mid, hi);
      // copy to aux
      for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
      }

      int i = lo;
      int j = mid + 1;
      for (int k = lo; k <= hi; k++) {
        if(i > mid)
          a[k] = aux[j++];
        else if(j>hi)
          a[k] = aux[i++];
        else if(aux[i]<aux[j])
          a[k] = aux[i++];
        else
          a[k] = aux[j++];
      }

    }
  }

  public static void main(String[] args) {
    int[] a = {11, 8, 3, 9, 7, 1, 2, 5};
    MergeSort(a);
    PrintUtil.show(a);
//    0, 0, 1
//    2, 2, 3
//    0, 1, 3
//    4, 4, 5
//    6, 6, 7
//    4, 5, 7
//    0, 3, 7
//    [1, 2, 3, 5, 7, 8, 9, 11]

  }
}
