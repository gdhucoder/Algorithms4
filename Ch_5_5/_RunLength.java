package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * Created by HuGuodong on 2019/3/12.
 */

public class _RunLength {

  private static final int R = 256;
  private static final int LG_R = 8;

  public static void expand() {

    boolean b = false;
    while (!BinaryStdIn.isEmpty()){
      int run = BinaryStdIn.readInt(LG_R);
      for (int i = 0; i < run; i++) {
        BinaryStdOut.write(b);
      }
      b = !b;
    }
    BinaryStdOut.close();
  }

  public static void compress() {
    char run = 0;
    boolean old = false;
    while (!BinaryStdIn.isEmpty()) {
      boolean b = BinaryStdIn.readBoolean();
      if (b != old) {
        BinaryStdOut.write(run, LG_R);
        run = 1;
        old = !old;
      }else{
        if(run == R-1){
          BinaryStdOut.write(run, LG_R);
          run = 0;
          BinaryStdOut.write(run, LG_R); // 为什么要写0呢
        }
        run++;
      }
    }
    BinaryStdOut.write(run, LG_R);
    BinaryStdOut.close();

  }

  public static void main(String[] args) {
    if (args[0].equals("-"))
      compress();
    if (args[0].equals("+"))
      expand();
  }

}
