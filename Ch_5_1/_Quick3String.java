package Ch_5_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/1/23.
 */

public class _Quick3String {

  private static int charAt(String s, int d) {
    if (d < s.length()) {
      return s.charAt(d);
    } else {
      return -1;
    }
  }

  public static void sort(String[] a) {
    sort(a, 0, a.length - 1, 0);
  }

  private static void sort(String[] a, int lo, int hi, int d) {
    if (hi <= lo) {
      return;
    }
    int lt = lo, gt = hi;
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

  public static void main(String[] args) {
    String str = "she, shells, seashells, by, the, sea, shore, the, shells, she, shells, are, surely, seashells";
    String[] a = str.replaceAll(" ", "").split(",");
    sort(a);
    for(String s : a){
      StdOut.print(s+"\t");
    }
    StdOut.println();
  }
}
