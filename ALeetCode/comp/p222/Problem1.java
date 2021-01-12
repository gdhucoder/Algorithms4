package ALeetCode.comp.p222;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
      int res = 0;
      int cnt = 0;
      Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
      //      PrintUtil.show(boxTypes);
      for (int i = 0; i < boxTypes.length; i++) {
        int[] box = boxTypes[i];
        if (cnt + box[0] < truckSize) {
          res += box[0] * box[1];
          cnt += box[0];
        }
        else {
          System.out.println(cnt);
          res += (truckSize - cnt) * box[1];
          break;
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] in = {{1, 3}, {2, 2}, {3, 1}};
    System.out.println(s.maximumUnits(in, 4));
  }
}
