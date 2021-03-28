package ALeetCode.comp.p234;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public static int numDifferentIntegers(String word) {
      StringBuilder sb = new StringBuilder();
      Set<String> set = new HashSet<>();
      char[] chs = word.toCharArray();
      for (int i = 0; i < chs.length; i++) {
        char c = chs[i];
        if (c >= '0' && c <= '9') {
          sb.append(c);
        }
        else if (sb.length() > 0) {
          String num = deletePreZero(sb.toString());
          set.add(num);
          sb.setLength(0);
        }
      }
      if (sb.length() > 0) {
        String num = deletePreZero(sb.toString());
        set.add(num);
        sb.setLength(0);
      }
      return set.size();
    }
  }

  private static String deletePreZero(String input) {
    int index = 0;
    while (index < input.length() && input.charAt(index) == '0') {
      index++;
    }
    return input.substring(index, input.length());
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    int res = s.numDifferentIntegers("0a0");
    System.out.println(res);
  }
}
