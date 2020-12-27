package ALeetCode.comp.p221;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2_ref {

  static class Solution {

    public int eatenApples(int[] apples, int[] days) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
      int ans = 0;
      for (int d = 0; d < 100000; d++) {
        if (d < apples.length) {
          pq.add(new int[]{d + days[d] - 1, apples[d]});
        }
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
          int[] cur = pq.poll();
          cur[1]--;
          ans++;
          if (cur[1] > 0) {
            pq.add(cur);
          }
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
