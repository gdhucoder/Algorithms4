package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/18.
 */
public class P0070 {

  /**
   * 爬楼梯 回溯+备忘录 https://leetcode-cn.com/problems/climbing-stairs/submissions/
   */
  static class Solution {

    private int[] states;

    public int climbStairs(int n) {
      // sum = f(n-1) + f(n-2)
      states = new int[n];
      return f(n - 1, n - 1);
    }

    public int f(int i, int n) {
      if (i == 0) {
        return 1;
      }
      if (i == 1) {
        return 2;
      }
      if (states[i] != 0) {
        return states[i];
      }
      int sum = 0;
      if (i - 1 >= 0) {
        int x = f(i - 1, n);
        sum += x;
        states[i - 1] = x;
      }
      if (i - 2 >= 0) {
        int x = f(i - 2, n);
        sum += x;
        states[i - 2] = x;
      }
      return sum;
    }
  }
}
