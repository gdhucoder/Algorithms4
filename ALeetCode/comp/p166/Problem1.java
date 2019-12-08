package ALeetCode.comp.p166;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int subtractProductAndSum(int n) {
      int sum = 0;
      int mult = 1;
      while (n > 0) {
        int tail = n % 10;
        sum += tail;
        mult *= tail;
        n = n / 10;
      }
      return mult - sum;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subtractProductAndSum(4421));
  }
}
