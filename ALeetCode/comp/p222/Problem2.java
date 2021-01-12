package ALeetCode.comp.p222;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    static final int MOD = 1000000007;

    public int countPairs(int[] deliciousness) {
      int res = 0;
      for (int i = 0; i < deliciousness.length; i++) {
        for (int j = i + 1; j < deliciousness.length; j++) {
          int sum = deliciousness[i] + deliciousness[j];
          if (sum > 0 && ((sum & (sum - 1)) == 0)) {
            res++;
            res %= MOD;
          }
        }
      }
      return res;
    }


    private class Pair {

      int a;
      int b;
    }

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] in = {1, 1, 1, 3, 3, 3, 7};
    System.out.println(s.countPairs(in));
  }
}
