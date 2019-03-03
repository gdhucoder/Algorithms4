package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_18 {

  public static int mystery(int a, int b) {
    if (b == 0)
      return 0;
    if (b % 2 == 0)
      return mystery(a + a, b / 2);
    return mystery(a + a, b / 2) + a;
  }

  public static int mysteryV2(int a, int b) {
    if (b == 0)
      return 1;
    if (b % 2 == 0)
      return mysteryV2(a * a, b / 2);
    return mysteryV2(a * a, b / 2) * a;
  }

  public static void main(String[] args) {
    StdOut.println(mystery(2,25)); // 50
    StdOut.println(mystery(3,11)); // 33
    StdOut.println(mysteryV2(2,25)); // 33554432
    StdOut.println(mysteryV2(3,11)); // 177147
  }

}
