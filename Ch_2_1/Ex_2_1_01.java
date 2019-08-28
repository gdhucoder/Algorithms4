package Ch_2_1;

import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-08-29.
 */
public class Ex_2_1_01 extends _Example {

  public static void sort(Comparable[] a) {
    StdOut.printf("%4s %4s: ", "i", "min");
    PrintUtil.show(a);
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min]))
          min = j;
      }
      StdOut.printf("%4d %4d: ", i, min);
      PrintUtil.show(a);
      exch(a, i, min);
    }
  }

  public static void main(String[] args) {
    String[] a = "E A S Y Q U E S T I O N".split(" ");
    sort(a);
    assert isSorted(a);
    StdOut.printf("%4s %4s: ", "", "");
    PrintUtil.show(a);

//    i  min: E A S Y Q U E S T I O N
//    0    1: E A S Y Q U E S T I O N
//    1    1: A E S Y Q U E S T I O N
//    2    6: A E S Y Q U E S T I O N
//    3    9: A E E Y Q U S S T I O N
//    4   11: A E E I Q U S S T Y O N
//    5   10: A E E I N U S S T Y O Q
//    6   11: A E E I N O S S T Y U Q
//    7    7: A E E I N O Q S T Y U S
//    8   11: A E E I N O Q S T Y U S
//    9   11: A E E I N O Q S S Y U T
//    10  10: A E E I N O Q S S T U Y
//    11  11: A E E I N O Q S S T U Y
//          : A E E I N O Q S S T U Y
  }
}
