package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/19.
 */

public class Ex_1_2_05 {

  public static void test2(){
    String s = "Hello World";
    s = s.toUpperCase();
    s = s.substring(6, 11);
    StdOut.println(s);
  }

  public static void test1(){
    String s = "Hello World";
    s.toUpperCase();
    s.substring(6, 11);
    StdOut.println(s);
  }

  public static void main(String[] args) {
    test1(); // Hello World
    test2(); // WORLD
  }
}
