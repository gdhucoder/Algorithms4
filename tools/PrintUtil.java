package tools;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by HuGuodong on 2019/1/31.
 */

public class PrintUtil {

  private PrintUtil() {}

  public static void show(Iterable iterable) {
    for (Object o :
        iterable) {
      StdOut.printf("%s \t", o);
    }
    StdOut.println();
  }

  public static void show(int[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.printf("%d ", a[i]);
    }
    StdOut.println();
  }

  public static void show(double[] a) {
    StdOut.println(Arrays.toString(a));
  }

  public static void show(Object[] a) {
    for (Object o : a) {
      StdOut.print(o.toString() + "\t");
    }
    StdOut.println();
  }

  public static void show(double[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        StdOut.print(a[i][j] + "\t");
      }
      StdOut.println();
    }
    StdOut.println();
  }


  public static void show(Object[] a, String sep) {
    for (Object o : a) {
      StdOut.print(o.toString() + sep);
    }
    StdOut.println();
  }

  public static void show(Collection c) {
    for (Object o :
        c) {
      StdOut.println(o.toString());
    }
  }

  public static void printPlaceholder(char placeholder, int n) {
    for (int i = 0; i < n; i++) {
      StdOut.print(placeholder);
    }
  }
}
