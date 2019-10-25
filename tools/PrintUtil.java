package tools;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

/**
 * Created by HuGuodong on 2019/1/31.
 */

public class PrintUtil {

  private PrintUtil() {}

  public static void show(Iterable iterable) {
    for (Object o :
        iterable) {
      StdOut.printf("%s ", o);
    }
    StdOut.println();
  }

  public static void show(Iterable iterable, boolean reverse) {
    Stack<Object> s = new Stack<>();
    for (Object o :
        iterable) {
      s.push(o);
    }
    show(s);
  }

  public static void show(int[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.printf("%d ", a[i]);
    }
    StdOut.println();
  }

  public static void show(int[] a, char sep) {
    for (int i = 0; i < a.length; i++) {
      StdOut.printf("%d ", a[i]);
    }
    StdOut.print(sep);
  }


  public static void show(double[] a) {
    StdOut.println(Arrays.toString(a));
  }

  public static void show(Object[] a) {
    for (Object o : a) {

      StdOut.print(o == null ? "null " : o.toString() + " ");
    }
    StdOut.println();
  }

  public static void show(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        StdOut.print(a[i][j] + "\t");
      }
      StdOut.println();
    }
    StdOut.println();
  }

  public static void show(Object[] a, char sep) {
    for (Object o : a) {
      StdOut.print((o == null ? "null" : o.toString()) + sep);
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
      StdOut.printf("%s \t", o);
    }
  }

  public static void printPlaceholder(char placeholder, int n) {
    for (int i = 0; i < n; i++) {
      StdOut.print(placeholder);
    }
  }
}
