package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/19.
 */

public class Ex_1_2_06 {

  public static boolean isCircular(String s, String t) {
    return s.length() == t.length() && (s + s).indexOf(t) != -1;
  }

  public static void main(String[] args) {
    String s = "ACTGACG";
    String t = "TGACGAC";
    StdOut.println(isCircular(s, t));
    s = "123456789";
    t = "912345678";
    StdOut.println(isCircular(s, t));
  }
}
