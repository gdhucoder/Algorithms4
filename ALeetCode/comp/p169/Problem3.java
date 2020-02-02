package ALeetCode.comp.p169;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int makeConnected(int n, int[][] connections) {
      if (n - 1 > connections.length)
        return -1;
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < connections.length; i++) {
        set.add(connections[i][0]);
        set.add(connections[i][1]);
      }

      return n - set.size();
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
