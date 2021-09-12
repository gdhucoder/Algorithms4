package ALeetCode.comp.p258;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public long interchangeableRectangles(int[][] rectangles) {
      Map<Double, Integer> map = new HashMap<>();
      for (int[] pair : rectangles) {
        double key = (0.0 + pair[0]) / pair[1];
        int cnt = map.getOrDefault(key, 0) + 1;
        map.put(key, cnt);
      }
      long res = 0;
      for (Entry<Double, Integer> entry : map.entrySet()) {
        int cnt = entry.getValue();
        if (cnt > 1) {
          res += ((long) cnt * (cnt - 1)) / 2;
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
