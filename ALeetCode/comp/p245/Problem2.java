package ALeetCode.comp.p245;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {
      Map<Character, Set<Integer>> map = new HashMap<>();
      for (char c : p.toCharArray()) {
        map.put(c, new HashSet<>());
      }
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) {
          map.get(c).add(i);
        }
        //        else {
        //          map.put(c, new HashSet<>());
        //          map.get(c).add(i);
        //        }
      }

      int res = 0;
      for (int r : removable) {
        char c = s.charAt(r);
        res++;
        if (map.containsKey(c)) {
          map.get(c).remove(r);
          if (map.get(c).size() < 1) {
            break;
          }
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
