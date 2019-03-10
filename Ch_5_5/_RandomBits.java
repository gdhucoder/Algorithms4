package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * Created by HuGuodong on 2019/3/11.
 */

public class _RandomBits {

  public static void main(String[] args) {
    int x = 11111;
    for (int i = 0; i < 1000000; i++) {
      x = x * 314159 + 218281;
      BinaryStdOut.write(x>0);
    }
    BinaryStdOut.close();
  }
}
