package ALeetCode.comp.p253;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minStoneSum(int[] piles, int k) {
      PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> (b - a));
      for (int num : piles) {
        que.offer(num);
      }
      for (int i = 0; i < k; i++) {
        int num = que.poll();
        que.offer((int) Math.floor(num / 2));
      }
      int result = 0;
      while (!que.isEmpty()) {
        result += que.poll();
      }
      return result;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
