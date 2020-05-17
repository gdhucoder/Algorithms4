package ALeetCode.comp.p189;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int busyStudent(int[] s, int[] e, int q) {
      int len = s.length, res = 0;
      for (int i = 0; i < len; i++) {
        if (q >= s[i] && q <= e[i]) res++;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
