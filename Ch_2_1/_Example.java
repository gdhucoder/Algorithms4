package Ch_2_1;

import edu.princeton.cs.algs4.StdIn;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-22.
 */
public class _Example {

  public static void sort(Comparable[] a) {
    // see algorithms 2.1 2.2 2.3 2.4
  }

  public static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1]))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    PrintUtil.show(a);
  }


}
