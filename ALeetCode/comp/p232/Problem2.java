package ALeetCode.comp.p232;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int findCenter(int[][] edges) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int[] e : edges) {
        if (!map.containsKey(e[0])) {
          map.put(e[0], new ArrayList<>());
        }
        if (!map.containsKey(e[1])) {
          map.put(e[1], new ArrayList<>());
        }
        List<Integer> list1 = map.get(e[0]);
        list1.add(e[1]);
        List<Integer> list2 = map.get(e[1]);
        list2.add(e[0]);
      }

      for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
        if (e.getValue().size() == edges.length) {
          return e.getKey();
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
