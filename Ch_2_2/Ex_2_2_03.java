package Ch_2_2;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2022/3/14.
 */
public class Ex_2_2_03 {

  public static void main(String[] args) {
    Character[] a = ArrayGenerator.toCharacterArray("EASYQUESTION".toCharArray());
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
  }

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    System.out.printf("merge(a,%2s,%2s,%2s) ", lo, mid, hi);
    for (int i = lo; i <= hi; i++) {
      aux[i] = a[i];
    }

    int i = lo, j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      }
      else if (j > hi) {
        a[k] = aux[i++];
      }
      else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      }
      else {
        a[k] = aux[j++];
      }
    }
    PrintUtil.show(a, lo, hi, false);
  }

  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }
}
