package Ch_2_4;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/6/3.
 */

public class _HeapSort {

  public static void sort(Comparable[] a) {

    // heap construction
    int N = a.length;
    for (int k = N / 2; k >= 1; k--) {
      sink(a, k, N);
    }
    // sortdown
    while (N > 1) {
      exch(a, 1, N--);
      sink(a, 1, N);
    }
  }

  private static void sink(Comparable[] a, int k, int N) {
    while (2*k <= N) {
      int j = 2 * k;
      if (j<N && less(a, j, j + 1)) {
        j++;
      }
      if (!less(a, k, j)) {
        break;
      }
      exch(a, k, j);
      k = j;
    }
  }

  private static void exch(Object[] a, int i, int j) {
    Object temp = a[i-1];
    a[i-1] = a[j-1];
    a[j-1] = temp;
  }

  private static boolean less(Comparable[] a, int i, int j) {
    return a[i-1].compareTo(a[j-1]) < 0;
  }

  public static void main(String[] args) {
    Integer[] a = ArrayGenerator.randomIntArray(5);
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
  }
}
