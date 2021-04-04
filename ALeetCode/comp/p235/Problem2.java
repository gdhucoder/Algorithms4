package ALeetCode.comp.p235;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
      Map<Integer, Set<Integer>> map = new HashMap<>();
      for (int[] log : logs) {
        if (!map.containsKey(log[0])) {
          map.put(log[0], new HashSet<Integer>());
        }
        map.get(log[0]).add(log[1]);
      }
      int[] res = new int[k];
      for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
        Set<Integer> set = entry.getValue();
        res[set.size() - 1]++;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
