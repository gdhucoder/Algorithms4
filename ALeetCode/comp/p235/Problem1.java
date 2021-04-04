package ALeetCode.comp.p235;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String truncateSentence(String s, int k) {
      String[] arr = s.split("//s+");
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < k; i++) {
        res.append(arr[i]).append(" ");
      }
      res.setLength(res.length() - 1);
      return res.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
