package ALeetCode.comp.p221;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    /**
     * 思路：先吃最早腐烂的苹果
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
      int ans = 0;
      // a[0] 表示第几天过期
      // a[1] 表示有几个苹果
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
      for (int d = 0; d < 100000; d++) {
        if (d < days.length) {
          pq.offer(new int[]{d + days[d] - 1, apples[d]});
        }
        // 清除过期的苹果
        while (!pq.isEmpty()) {
          int[] cur = pq.peek();
          if (cur[0] < d) {
            pq.poll();
          }
          else {
            break;
          }
        }
        if (!pq.isEmpty()) {
          // 吃苹果
          int[] cur = pq.peek();
          if (cur[1] > 0) {
            cur[1]--;
            ans++;
          }
          // 从队列中清除吃完的苹果
          if (cur[1] == 0) pq.poll();
        }
      }
      return ans;
    }
  }

  //[9,10,1,7,0,2,1,4,1,7,0,11,0,11,0,0,9,11,11,2,0,5,5]
  //    [3,19,1,14,0,4,1,8,2,7,0,13,0,13,0,0,2,2,13,1,0,3,7]
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5};
    int[] b = new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
    System.out.println(s.eatenApples(a, b));
  }
}
