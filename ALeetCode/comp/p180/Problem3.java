package ALeetCode.comp.p180;

import java.util.LinkedList;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
      boolean[] mark = new boolean[n];
      LinkedList<Integer> que = new LinkedList<>();
      que.addLast(headID);
      int sum = 0;
      while (!que.isEmpty()) {
        int size = que.size();
        for (int i = 0; i < size; i++) {
          int upper = que.removeFirst();
          int total = 0;
          for (int j = 0; j < manager.length; j++) {
            if (manager[j] == upper) {
              total = Math.max(informTime[j], total);
              que.addLast(j);
            }
          }
          sum += total;
        }
      }
      return sum;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    //    n = 4, headID = 2, manager = [3,3,-1,2], informTime = [0,0,162,914]
    int[] m = {3, 3, -1, 2};
    int[] inf = {0, 0, 162, 914};

    Solution s = new Solution();
  }
}
