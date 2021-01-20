package ALeetCode.comp.p224;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int countGoodRectangles(int[][] rectangles) {
      Map<Integer, Integer> map = new HashMap<>();
      int maxCnt = 0;
      for (int[] rec : rectangles) {
        int min = Math.min(rec[0], rec[1]);
        int cnt = map.getOrDefault(min, 0) + 1;
        map.put(min, cnt);
        maxCnt = Math.max(maxCnt, min);
      }

      return 0;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
