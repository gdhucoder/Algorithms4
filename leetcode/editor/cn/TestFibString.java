package leetcode.editor.cn;

/**
 * Created by HuGuodong on 1/16/20.
 */
public class TestFibString {

  public static void main(String[] args) {
    TestFibString s = new TestFibString();
    //    System.out.println(s.fib(150));
    long k = 1000000000;
    int i = 2;
    while (k > 0) {
      long fib = s.fib(i++);
      k = k - fib;
      System.out.println(k + ": " + i + ":" + fib);
    }
  }

  public long fib(int n) {
    long one = 1;
    long tow = 1;
    long three = -1;
    for (int i = 2; i <= n; i++) {
      three = one + tow;
      one = tow;
      tow = three;
    }
    return tow;
  }
}
