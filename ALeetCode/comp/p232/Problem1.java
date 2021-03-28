package ALeetCode.comp.p232;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
      int cnt = 0;
      char[] notEqualS1 = new char[2];
      char[] notEqualS2 = new char[2];
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          cnt++;
          if (cnt >= 3) return false;
          notEqualS1[i++] = s1.charAt(i);
          notEqualS2[i++] = s2.charAt(i);
        }
      }
      if (cnt == 2) {
        Arrays.sort(notEqualS1);
        Arrays.sort(notEqualS2);
        for (int i = 0; i < 2; i++) {
          if (notEqualS1[i] != notEqualS2[1]) {
            return false;
          }
        }
      }
      return cnt == 2 || cnt == 0;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
