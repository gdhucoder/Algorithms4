package ALeetCode.comp.p231;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean checkOnesSegment(String s) {
      char[] chs = s.toCharArray();
      char pre = '1';
      for (int i = 1; i < chs.length; i++) {
        char c = chs[i];
        if (c == '1' && pre == '0') {
          return false;
        }
        pre = c;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
