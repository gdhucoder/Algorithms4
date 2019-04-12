package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/4/13.
 */

public class Ex_1_1_24 {

  public static int gcd(int p, int q, int recurLevel) {
    printIndent(recurLevel);
    StdOut.printf("p = %d, q = %d\n", p, q);

    if (q == 0) {
      return p;
    }
    int r = p % q;
    return gcd(q, r, recurLevel+1);
  }

  private static void printIndent(int n) {
    StdOut.printf("level %d: ", n);
    for (int i = 0; i < n; i++) {
      StdOut.print("--");
    }
  }

  public static void main(String[] args) {
    int p = 105;
    int q = 24;
    int gcd = gcd(p, q, 0);
    StdOut.printf("gcd = %d\n", gcd);

    p = 1111111;
    q = 1234567;
    gcd = gcd(p, q, 0);
    StdOut.printf("gcd = %d\n", gcd);

//    level 0: p = 105, q = 24
//    level 1: --p = 24, q = 9
//    level 2: ----p = 9, q = 6
//    level 3: ------p = 6, q = 3
//    level 4: --------p = 3, q = 0
//    gcd = 3
//    level 0: p = 1111111, q = 1234567
//    level 1: --p = 1234567, q = 1111111
//    level 2: ----p = 1111111, q = 123456
//    level 3: ------p = 123456, q = 7
//    level 4: --------p = 7, q = 4
//    level 5: ----------p = 4, q = 3
//    level 6: ------------p = 3, q = 1
//    level 7: --------------p = 1, q = 0
//    gcd = 1
  }

}
