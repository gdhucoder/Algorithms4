package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/4.
 */

public class Ex_1_3_05 {

  public static void showBinaryN(int N) {
    _VarySizedCapacityStack<Integer> stack = new _VarySizedCapacityStack<>();
    while (N > 0) {
      stack.push(N % 2);
      N = N / 2;
    }
    for (int d :
        stack) {
      StdOut.printf("%d", d);
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    int N = 50;
    showBinaryN(N);
    StdOut.println(Integer.toBinaryString(N));
//    110010
//    110010
  }
}
