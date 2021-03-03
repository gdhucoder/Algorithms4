package ALeetCode.comp.p230;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    int target;
    int[] baseCosts;
    int[] toppingCosts;
    int best = Integer.MAX_VALUE;
    PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> {
      if (Math.abs(target - a) == Math.abs(target - b)) {
        return a - b;
      }
      else {
        return Math.abs(target - a) - Math.abs(target - b);
      }
    });

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
      this.target = target;
      this.baseCosts = baseCosts;
      this.toppingCosts = toppingCosts;
      boolean[] used = new boolean[toppingCosts.length];
      for (int i = 0; i < baseCosts.length; i++) {
        best = Math.min(Math.abs(target - helper(used, 0, baseCosts[i])), best);
      }
      return que.poll();
    }

    public int helper(boolean[] used, int i, int sum) {
      //
      if (i == toppingCosts.length) {
        que.offer(sum);
        return sum;
      }

      //      if (i < toppingCosts.length && target <= sum + toppingCosts[i]) {
      //        que.offer(sum);
      //        que.offer(sum + toppingCosts[i]);
      //        return que.peek();
      //      }
      used[i] = true;
      int sum1 = helper(used, i + 1, sum + toppingCosts[i]);
      int sum2 = helper(used, i + 1, sum + toppingCosts[i] * 2);
      used[i] = false;
      int sum3 = helper(used, i + 1, sum);

      System.out.println("sum1:->" + sum1);
      System.out.println("sum2:->" + sum2);
      System.out.println("sum3:->" + sum3);
      que.offer(sum1);
      que.offer(sum2);
      que.offer(sum3);
      return que.peek();

    }


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] base = {5, 9};
    int[] c = {10, 1};
    int t = 7;
    System.out.println(s.closestCost(base, c, t));
  }
}
