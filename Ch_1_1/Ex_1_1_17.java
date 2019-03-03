package Ch_1_1;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_17 {
  public static String exR2(int n) {
    String s = exR2(n-3) + n + exR2(n-2) + n;
    if (n <= 0) return "";
    return s;
  }

  public static void main(String[] args) {
    exR2(3);
//    Exception in thread "main" java.lang.StackOverflowError
  }
}
