package Ch_5_1;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/19.
 */

public class Ex_5_1_13 {

  public static int charAt(String s, int d) {
    if (d < s.length()) {
      return s.charAt(d);
    } else {
      return -1;
    }
  }

  public static class MSD {

    private static String[] aux;
    private static final int R = 256;

    public static void sort(String[] a) {
      int N = a.length;
      aux = new String[N];
      sort(a, 0, N - 1, 0);
    }

    public static void sort(String[] a, int lo, int hi, int d) {

      // cut off for small sub array
      if (hi - 2 <= lo) {
        Quick3String.sort(a, lo, hi, d);
        return;
      }
      int[] count = new int[R + 2];
      for (int i = lo; i <= hi; i++) {
        count[charAt(a[i], d) + 2]++;
      }
      for (int r = 0; r < R + 1; r++) {
        count[r + 1] += count[r];
      }
      for (int i = lo; i <= hi; i++) {
        aux[count[charAt(a[i], d) + 1]++] = a[i];
      }
      for (int i = lo; i <= hi; i++) {
        a[i] = aux[i - lo];
      }
      for (int r = 0; r < R; r++) {
        sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
      }
    }

  }

  public static class Quick3String {

    public static void sort(String[] a, int lo, int hi, int d) {
      if (hi <= lo) {
        return;
      }
      int lt = lo;
      int gt = hi;
      int v = charAt(a[lo], d);
      int i = lo + 1;
      while (i <= gt) {
        int t = charAt(a[i], d);
        if (t < v)
          exch(a, lt++, i++);
        else if (t > v)
          exch(a, i, gt--);
        else
          i++;
      }
      sort(a, lo, lt - 1, d);
      if (v >= 0)
        sort(a, lt, gt, d + 1);
      sort(a, gt + 1, hi, d);
    }

    private static void exch(String[] a, int i, int j) {
      String temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }

  }

  public static void sort(String[] a) {
    MSD.sort(a);
  }

  public static void main(String[] args) {
    String s = "she, shells, aaaaaaaaaaa, aaa ,seashells, by, the, sea, shore, the, shells, she, shells, are, surely, seashells, zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    String[] a = s.replaceAll(" ", "").split(",");
    sort(a);
    PrintUtil.show(a);
  }


}
