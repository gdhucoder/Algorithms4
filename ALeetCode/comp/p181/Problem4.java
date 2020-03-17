package ALeetCode.comp.p181;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
      boolean[] used = new boolean[n];
      helper(0, k, n, 0, 0, speed, efficiency, used);
      return 0;
    }

    private void helper(int level, int k, int n, int sum_speed, int min, int[] speed, int[] eff,
        boolean[] used) {
      if (level == k) {
        System.out.println(sum_speed * min % 10000007);
        return;
      }

      for (int i = 0; i < n; i++) {
        if (!used[i]) {
          used[i] = true;
          helper(level + 1, k, n, sum_speed += speed[i], Math.min(min, eff[i]), speed, eff, used);
          used[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println();
  }
}
