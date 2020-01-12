package ALeetCode.comp.p171;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int[] getNoZeroIntegers(int n) {
      int[] res = new int[2];
      for (int i = 0; i < n; i++) {
        if (!hasZero(i) && !hasZero(n - i)) {
          res[0] = i;
          res[1] = n - i;
          break;
        }
      }
      return res;
    }

    private boolean hasZero(int n) {
      
      while (n != 0) {
        if (n % 10 == 0) {
          return true;
        }
        n = n / 10;
      }
      return false;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.hasZero(0));
  }
}
