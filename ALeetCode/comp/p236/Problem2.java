package ALeetCode.comp.p236;

import java.util.ArrayList;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int findTheWinner(int n, int k) {
      var list = new ArrayList<Integer>();
      for (int i = 1; i <= n; i++) {
        list.add(i);
      }
      var j = 0;
      while (list.size() > 1) {
        j += k - 1;
        j %= list.size();
        list.remove(j);
      }
      return list.get(0);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
