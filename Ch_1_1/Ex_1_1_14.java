package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/2.
 */

public class Ex_1_1_14 {

  /**
   *
   * @param N
   * @return
   */
  public static int lg(int N) {

    int ret = 0;
    while (N > 0) {
      N /= 2;
      ret++;
    }
    return ret - 1;
  }

  public static void main(String[] args) {
    int number = 4;
    int n = lg(number);

    // 检查一下
    int mathN = (int) (Math.log(number) / Math.log(2));
    StdOut.println("log of " + number + " (base-2) is : " + n);
    StdOut.println(mathN);

//    log of 4 (base-2) is : 2
//    2
  }
}
