package geekbang.u38;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-10-19.
 */
public class InversionNumber {

  private static int[] aux;
  private static int cnt = 0;


  public static void sort(int[] a) {
    aux = new int[a.length];
    sort(a, 0, a.length - 1);
  }

  public static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    mergeCount(a, lo, mid, hi);
  }

  public static void mergeCount(int[] a, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    int num = 0;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi) {
        a[k] = aux[i++];
      } else if (aux[i] <= aux[j]) {
        a[k] = aux[i++];// aux!!!
      } else {
        a[k] = aux[j++];
        cnt += mid - i + 1; // mid 与 i之间 大于 a[j]的个数
      }
    }
  }

  public static void main(String[] args) {
//    int[] a = ArrayGenerator.randomIntsArray(10);
//    int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//    int[] a = {3,2,1,4};
    int[] a = {4, 5, 6, 1, 2, 3};
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
    System.out.println(cnt);
  }
}
