package ALeetCode.comp.p190;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int maxVowels(String s, int k) {
      Set<Character> set = new HashSet<>();
      Map<Character, Integer> map = new HashMap<>();
      for (char c : "aeiou".toCharArray()) {
        set.add(c);
      }

      int res = 0;
      int right = 0, left = 0;
      int count = 0;
      while (right < s.length()) {
        while (right - left < k) {
          char r = s.charAt(right);
          if (set.contains(r)) {
            count++;
            map.putIfAbsent(r, map.getOrDefault(r, 0) + 1);
          }
          right++;
        }
        if (right - left == k) {
          res = Math.max(res, count);
        }

        char l = s.charAt(left);
        if (set.contains(l)) {
          count--;
          if (map.containsKey(l)) {
            map.put(l, map.get(l) - 1);
          }
        }
        left++;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "abciiidef";
    int k = 3;
    System.out.println(s.maxVowels(str, k));
  }
}
