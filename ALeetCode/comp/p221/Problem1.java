package ALeetCode.comp.p221;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean halvesAreAlike(String s) {
      Set<Character> set = new HashSet<>(
          Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
      int cnt = 0;
      for (int i = 0; i < s.length(); i++) {
        if (i < s.length() / 2 && set.contains(s.charAt(i))) cnt++;
        if (i >= s.length() / 2 && set.contains(s.charAt(i))) cnt--;
      }
      return cnt == 0;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
