package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/17.
 */

public class Ex_1_06 {

  public static void main(String[] args) {
//    1.1.6 What does the following program print?

    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
//    0
//    1
//    1
//    2
//    3
//    5
//    8
//    13
//    21
//    34
//    55
//    89
//    144
//    233
//    377
//    610
  }

}
