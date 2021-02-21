package ALeetCode.comp.p229;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] minOperations(String boxes) {

      int[] res = new int[boxes.length()];
      char[] chs = boxes.toCharArray();
      for (int i = 0; i < res.length; i++) {
        res[i] = cnt(chs, i);
      }
      return res;
    }

    private int cnt(char[] chs, int idx) {
      int res = 0;
      for (int i = 0; i < chs.length; i++) {
        if (idx != i && chs[i] == '1') {
          res += Math.abs(idx - i);
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
