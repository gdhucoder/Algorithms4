package Ch_1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/14.
 */

public class _Cat {

  /**
   * read multiple inputs, and output to a file
   * @param args
   */
  public static void main(String[] args) {
    Out out = new Out(args[args.length-1]);
    for (int i = 0; i < args.length - 1; i++) {
      In in = new In(args[i]);
      String s = in.readAll();
      out.println(s);
      StdOut.println("txt read: " + s);
      in.close();
    }
    out.close();
  }
}
