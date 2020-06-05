package ALeetCode.interview.day01;

/**
 * Created by HuGuodong on 2020/6/5.
 */
public class TestException {

  public static void main(String[] args) {
    System.out.println(parseInt("42"));
    System.out.println(parseInt("zero")); // 先执行了
  }

  public static int parseInt(String s) {
    try {
      return Integer.parseInt(s);
    } finally {
      return 0;
    }
  }
}
