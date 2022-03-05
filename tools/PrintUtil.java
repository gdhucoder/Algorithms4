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

  public static void printSepLine(String word) {
    StdOut.println("-----------------------" + word + "-------------------------------");
  }

  public static void printSepLine() {
    StdOut.println("------------------------------------------------------");
  }

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

  public static void show(boolean[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.printf("%s ", a[i]);
    }
    StdOut.println();
  }

  public static void show(int[] a, boolean equalLength) {
    for (int i = 0; i < a.length; i++) {
      StdOut.printf("%3d ", a[i]);
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

  public static void show(Object[] a, int startInclude, int endInclude, boolean inline) {
    for (int i = 0; i < a.length; i++) {
      Object o = a[i];
      if (i < startInclude) {
        StdOut.print("  ");
      }
      else if (i >= startInclude && i <= endInclude) {
        StdOut.print(o == null ? "null " : o + " ");
      }
      else {
        StdOut.print("  ");
      }
    }
    if (!inline) {
      StdOut.println();
    }
  }

  public static void show(Integer[][] a) {
    for (Object[] o : a) {
      for (Object oo : a) {
        StdOut.print(oo == null ? "null " : o.toString() + " ");
      }
      System.out.println();
    }
    StdOut.println();
  }

  public static void show(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        StdOut.printf("%5s", a[i][j]);
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
