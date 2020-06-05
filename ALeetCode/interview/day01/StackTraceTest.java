package ALeetCode.interview.day01;

/**
 * Created by HuGuodong on 2020/6/5.
 */
public class StackTraceTest {

  public static void main(String[] args) {
    frac(3);
  }

  public static int frac(int n) {
    System.out.println("frac: " + n);
    var walker = StackWalker.getInstance();
    walker.forEach(System.out::println);
    if (n <= 1) return 1;
    else return n * frac(n - 1);
  }
}
