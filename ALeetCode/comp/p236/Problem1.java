package ALeetCode.comp.p236;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int arraySign(int[] nums) {
      int[] cnt = new int[3];
      for (int n : nums) {
        if (n > 0) cnt[0]++;
        else if (n == 0) cnt[1]++;
        else cnt[2]++;
      }
      if (cnt[1] != 0) return 0;
      return cnt[2] % 2 == 0 ? 1 : -1;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
