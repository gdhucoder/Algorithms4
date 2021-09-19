package ALeetCode.comp.p259;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int finalValueAfterOperations(String[] operations) {
      int res = 0;
      for (String op : operations) {
        if (op.contains("++")) {
          res++;
        }
        else {
          res--;
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
