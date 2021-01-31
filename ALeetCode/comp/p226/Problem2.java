package ALeetCode.comp.p226;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] restoreArray(int[][] adjacentPairs) {
      int[] res = new int[adjacentPairs.length + 1];

      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < adjacentPairs.length; i++) {
        int[] pair = adjacentPairs[i];
        if (!map.containsKey(pair[0])) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          map.put(pair[0], list);
        }
        else {
          map.get(pair[0]).add(i);
        }
        if (!map.containsKey(pair[1])) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          map.put(pair[1], list);
        }
        else {
          map.get(pair[1]).add(i);
        }
      }
      int headIdx = 0;
      int headKey = 0;
      for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
        List<Integer> list = entry.getValue();
        if (list.size() == 1) {
          headIdx = list.get(0);
          headKey = entry.getKey();
          break;
        }
      }
      int cnt = 0;
      res[cnt++] = headKey;
      while (cnt < adjacentPairs.length) {
        int[] pair = adjacentPairs[headIdx]; // 当前的pair
        headKey = res[cnt - 1] == pair[0] ? pair[1] : pair[0]; // 下一个 key
        headIdx =
            map.get(headKey).get(0) == headIdx ? map.get(headKey).get(1) : map.get(headKey).get(0);
        res[cnt++] = headKey;
      }
      res[cnt] = res[cnt - 1] == adjacentPairs[headIdx][0] ? adjacentPairs[headIdx][1]
          : adjacentPairs[headIdx][0];
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] arr = {{2, 1}, {3, 4}, {3, 2}};
    System.out.println(s.restoreArray(arr));
  }
}
