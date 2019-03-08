package geekbang.u12;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/3/9.
 */

public class QuickSort {

  public static void sort(int[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(int[] a, int p, int r) {
    if (p >= r) {
      return;
    }
    int q = partition(a, p, r);
    sort(a, p, q - 1);
    sort(a, q + 1, r);

  }

  private static int partition(int[] a, int p, int r) {
    int pivot = a[r];
    int i = p;
    for (int j = p; j <= r - 1; j++) {
      if (a[j] < pivot) {
        exch(a, i, j);
        i++;
      }
    }
    exch(a, i, r);
    return i;
  }


  private static void exch(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = ArrayGenerator.randomIntsArray(100);
    sort(a);
    PrintUtil.show(a);
  }
}
