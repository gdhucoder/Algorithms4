package ALeetCode.comp.p191;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int maxProduct(int[] nums) {
      PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o1 - o2;
        }
      });
      for (int n : nums) {
        que.add(n);
      }
      return (que.poll() - 1) * (que.poll() - 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
