package ALeetCode.comp.p229;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String mergeAlternately(String w1, String w2) {
      int len = Math.min(w1.length(), w2.length());
      char[] chs1 = w1.toCharArray();
      char[] chs2 = w2.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < len; i++) {
        sb.append(chs1[i]).append(chs2[i]);
      }
      if (len == w1.length()) {
        sb.append(w2.substring(len));
      }
      else {
        sb.append(w1.substring(len));
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
