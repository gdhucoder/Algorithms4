package ALeetCode.comp.p197;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    static int[] cnts = new int[100000];
    static final int MOD = 1000000007;
    static int sum = 0;

    static {
      cnts[1] = 1;

      for (int i = 1; i < cnts.length; i++) {
        sum += i;
        sum %= MOD;
        cnts[i] = sum;
      }
    }

    public int numSub(String s) {
      int res = 0;
      String[] ss = s.split("0");
      for (int i = 0; i < ss.length; i++) {
        if (ss[i].length() > 0) {
          res += cnts[ss[i].length()];
          res %= MOD;
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
