package ALeetCode.comp.p194;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int xorOperation(int n, int start) {
      int res = start;
      for (int i = 1; i < n; i++) {
        int step = start + 2 * i;
        res ^= step;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.xorOperation(5, 0));
    System.out.println(s.xorOperation(4, 3));
    System.out.println(s.xorOperation(1, 7));
    System.out.println(s.xorOperation(10, 5));
  }
}
