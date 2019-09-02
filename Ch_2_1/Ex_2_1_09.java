package Ch_2_1;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import tools.ArrayGenerator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-09-02.
 */
public class Ex_2_1_09 extends _Example {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N / 3) {
      h = 3 * h + 1;
    }
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      StdOut.printf("%2d-sort ", h);
      PrintUtil.show(a);
      h = h / 3;
    }
  }

  public static void main(String[] args) {
    String[] a = "E A S Y S H E L L S O R T Q U E S T I O N".split(" ");
    sort(a);
//    13-sort E A E S S H E L L S O R T Q U S Y T I O N
//     4-sort E A E L L H E O N Q I R S S O S T T U S Y
//     1-sort A E E E H I L L N O O Q R S S S S T T U Y
  }

}
