package ALeetCode.comp.p186;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int maxScore(int[] cardPoints, int k) {
      int len = cardPoints.length;
      if (len == 0) return 0;
      PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2 - o1;
        }
      });
      int left_sum = 0;
      for (int i = 0; i < k; i++) {
        left_sum += cardPoints[i];
      }
      queue.add(left_sum);
      int right_sum = 0;
      for (int i = len - 1, j = k - 1; i >= len - k; i--, j--) {
        right_sum += cardPoints[i];
        left_sum -= cardPoints[j];
        queue.add(left_sum + right_sum);
      }
      return queue.peek();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {1, 79, 80, 1, 1, 1, 200, 1};
    int k = 3;
    System.out.println(s.maxScore(a, k));
  }
  //  [1,2,3,4,5,6,1]
  //      3
  //      [2,2,2]
  //      2
  //      [1,79,80,1,1,1,200,1]
  //      3
  //      [9,7,7,9,7,7,9]
  //      7
  //      [11,49,100,20,86,29,72]
  //      4
}
