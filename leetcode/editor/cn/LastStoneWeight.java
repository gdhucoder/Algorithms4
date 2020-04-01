//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public static void main(String[] args) {
    Solution solution = new LastStoneWeight().new Solution();
    int[] stones = {100, 10, 1, 2};
    System.out.println(solution.lastStoneWeight(stones));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
          return b - a;
        }
      });
      for (int s : stones) {
        pq.offer(s);
      }

      while (pq.size() != 1) {
        int y = pq.poll();
        int x = pq.poll();
        if (y - x != 0) pq.offer(y - x);
      }
      return pq.peek();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}