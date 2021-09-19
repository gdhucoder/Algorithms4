package ALeetCode.comp.p259;

import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    class Pair {

      Pair(int _i, int _v) {
        this.index = _i;
        this.val = _v;
      }

      int index;
      int val;
    }

    public int sumOfBeauties(int[] nums) {
      int len = nums.length;
      int res = 0;
      PriorityQueue<Pair> tail = new PriorityQueue<>((a, b) -> a.val - b.val);
      for (int i = 3; i < len; i++) {
        tail.add(new Pair(i, nums[i]));
      }
      PriorityQueue<Integer> front = new PriorityQueue<>((a, b) -> b - a);
      for (int i = 1; i <= len - 2; i++) {
        front.add(nums[i - 1]);
        if (!tail.isEmpty() && tail.peek().index == i) {
          tail.poll();
        }
        if (front.peek() < nums[i] && tail.peek().val > nums[i]) {
          res += 2;
        }
        else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
          res += 1;
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    PriorityQueue<Integer> front = new PriorityQueue<>((a, b) -> b - a);
    front.add(2);
    front.add(1);
    System.out.println(front.peek());
  }
}
