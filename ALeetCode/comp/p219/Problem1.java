package ALeetCode.comp.p219;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int numberOfMatches(int n) {
      int res = 0;
      while (n > 1) {
        res += n / 2;
        n = (n / 2) + (n % 2 == 0 ? 0 : 1);
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.numberOfMatches(7));
    System.out.println(s.numberOfMatches(14));
  }
}
