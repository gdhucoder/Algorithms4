package ALeetCode.comp.p182_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    private Map<Character, Integer> evl = new HashMap<>();
    private int sum = 0;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
      // evls
      for (char c : evil.toCharArray()) {
        evl.put(c, evl.getOrDefault(c, 0) + 1);
      }
      helper(0, n, s1.toCharArray(), s1, s2);
      return sum;
    }

    private void helper(int lvl, int n, char[] chs1, String s1, String s2) {

      if (lvl == n) {
        sum += 1;
        sum = sum % 1000000007;
        System.out.println(String.valueOf(chs1));
        return;
      }

      //      if (evl.containsKey(chs1[lvl])) return;

      char temp = chs1[lvl];
      for (int j = 'a'; j <= 'z'; j++) {
        chs1[lvl] = (char) j;
        if (!evl.containsKey((char) j) && String.valueOf(chs1).compareTo(s1) >= 0
            && String.valueOf(chs1).compareTo(s2) <= 0) {
          helper(lvl + 1, n, chs1, s1, s2);
        }
      }
      chs1[lvl] = temp;
    }
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    //    System.out.println(s.findGoodStrings(8, "leetcode", "leetgoes", "leet"));
    //    System.out.println(s.findGoodStrings(2, "aa", "da", "b"));
    //    System.out.println(s.findGoodStrings(2, "gx", "gz", "x"));
    System.out.println(s.findGoodStrings(3, "szc", "zyi", "p"));

  }
}
