package Ch_2_2;

import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2022/3/5.
 */
public class Ex_2_2_02 {

  private static Comparable[] aux;

  private static int depth = 0;

  public static void main(String[] args) {
    Character[] a = ArrayGenerator.toCharacterArray("EASYQUESTION".toCharArray());
    PrintUtil.show(a);
    sort(a);
    PrintUtil.show(a);
  }

  public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int low, int hi) {
    if (hi <= low) return;
    depth++;
    int mid = low + (hi - low) / 2;
    sort(a, low, mid);
    sort(a, mid + 1, hi);
    merge(a, low, mid, hi);
    depth--;
  }

  private static void merge(Comparable[] a, int low, int mid, int hi) {
    System.out.printf("merge(a,%2s,%2s,%2s) ", low, mid, hi);

    for (int i = low; i <= hi; i++) {
      aux[i] = a[i];
    }

    int i = low, j = mid + 1;

    for (int k = low; k <= hi; k++) {
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
    PrintUtil.show(a, low, hi, false);
  }

  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }
}
