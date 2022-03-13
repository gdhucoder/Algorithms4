package ALeetCode.comp.p283;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public List<String> cellsInRange(String s) {
      // <col1><row1>:<col2><row2>
      int[] cols = new int[5];
      char[] chs = s.toCharArray();
      for (int i = 0; i < chs.length; i++) {
        cols[i] = (int) chs[i];
      }
      List<String> res = new ArrayList<>();

      for (int i = cols[0]; i <= cols[3]; i++) {

        for (int j = cols[1]; j <= cols[4]; j++) {
          String ele = "" + (char) i + (char) j;
          res.add(ele);
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
