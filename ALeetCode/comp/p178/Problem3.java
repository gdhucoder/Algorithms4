package ALeetCode.comp.p178;

import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int[] closestDivisors(int num) {
      int[] res = new int[2];
      int min = Integer.MAX_VALUE;
      for (int i = 1; i < num + 2; i++) {
        for (int j = i; j < num + 2; j++) {
          long mult = i * j;
          if (mult == num + 1 || mult == num + 2) {
            if (j - i < min) {
              res[0] = i;
              res[1] = j;
            }
          }
        }
      }
      PrintUtil.show(res);
      return res;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    int[] tests = {170967091, 2, 8, 123, 999};
    for (int num : tests)
      s.closestDivisors(num);
  }
}
