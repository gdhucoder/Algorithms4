package ALeetCode.comp.p186;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int maxScore(String s) {
      char[] chs = s.toCharArray();
      int one_cnt = 0;
      for (char c : chs) {
        if (c == '1') one_cnt++;
      }
      int max = 0;
      int zero_cnt = 0;
      for (int i = 0; i < chs.length; i++) {
        if (chs[i] == '0') zero_cnt++;
        else one_cnt--;
        max = Math.max(zero_cnt + one_cnt, max);
      }
      return max;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
