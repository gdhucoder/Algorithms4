package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/11.
 */
public class P0007_1 {

  /**
   * Best solution
   *
   * @param x
   * @return
   */
  public static int reverse(int x) {
    long temp = 0;
    int ret = 0;
    while (x != 0) {
      int pop = x % 10;
      temp = temp * 10 + pop;
      if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
        return 0;
      }
      ret = ret * 10 + pop;
    }
    return ret;
  }
}
