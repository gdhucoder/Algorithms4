package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/19.
 */

public class Ex_1_2_07 {

  public static String mystery(String s) {
    int N = s.length();
    if (N <= 1)
      return s;
    String a = s.substring(0, N / 2);
    String b = s.substring(N / 2, N);
    return mystery(b) + mystery(a);
  }


  public static void main(String[] args) {
    StdOut.println(mystery("abcde")); // edcba
  }
}
