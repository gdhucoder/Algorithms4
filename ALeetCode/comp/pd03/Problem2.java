package ALeetCode.comp.pd03;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int findTheLongestSubstring(String s) {
      //      'a'，'e'，'i'，'o'，'u'
      int start = 0;
      int end = 0;
      Map<Character, Integer> map = new HashMap<>();
      map.put('a', 0);
      map.put('e', 0);
      map.put('i', 0);
      map.put('o', 0);
      map.put('u', 0);
      map.put('#', 0);
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        if (!map.containsKey(c)) {
          end++;
          map.put(c, 1);
        }
        else {
          if (map.get(c) == 1) {
            map.put(c, 2);
            end++;
          }
          else if (map.get(c) == 2) {

          }
        }
      }
      return 0;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
