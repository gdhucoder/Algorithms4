package ALeetCode.comp.p219;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minPartitions(String n) {
      int len = n.length();
      PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> (b - a));
      for (int i = 0; i < len; i++) {
        int num = n.charAt(i) - '0';
        if (num > 0) {
          que.offer(num);
        }
      }
      return que.peek();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
