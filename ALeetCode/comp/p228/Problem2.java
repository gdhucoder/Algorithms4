package ALeetCode.comp.p228;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    static int MOD = 1000000007;

    public int countHomogenous(String s) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(1, 1);
      for (int i = 2; i <= 100000; i++) {
        map.put(i, (map.get(i - 1) + i) % MOD);
      }
      int len = s.length();
      int start = 0, end = 1;
      int res = 0;
      while (end <= len) {
        if (end == len || s.charAt(start) != s.charAt(end)) {
          res += map.get(end - start) % MOD;
          start = end;
        }
        end++;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
    char pre = (char) 0;
    System.out.println((int) pre);
    s.countHomogenous("1");
  }
}
