package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import tools.ArrayGenerator;

/**
 * Created by HuGuodong on 2019/6/19.
 */

public class Ex_1_2_08 {

  public static void main(String[] args) {
    int[] a = ArrayGenerator.randomIntsArray(10000000);
    int[] b = ArrayGenerator.randomIntsArray(10000000);
    StdOut.println("a :" + a);
    StdOut.println("b :" + b);
    int[] t = a;
    a = b;
    b = t;
    StdOut.println("a :" + a);
    StdOut.println("b :" + b);
//    a :[I@7f31245a
//    b :[I@6d6f6e28
//    a :[I@6d6f6e28
//    b :[I@7f31245a
    // 交换了a与b的地址
  }
}
