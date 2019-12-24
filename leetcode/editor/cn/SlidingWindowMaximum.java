//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import tools.PrintUtil;

public class SlidingWindowMaximum {

  public static void main(String[] args) {
    Solution solution = new SlidingWindowMaximum().new Solution();
    int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] res = solution.maxSlidingWindow(a, k);
    PrintUtil.show(res);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
        return new int[]{};
      }
      Deque<Integer> que = new LinkedList<>();
      int[] res = new int[nums.length - k + 1];
      for (int i = 0; i < nums.length; i++) {
        if (i >= k && que.getFirst() <= i - k) {
          que.removeFirst();
        }
        while (!que.isEmpty() && nums[que.getLast()] < nums[i])
          que.removeLast();
        que.addLast(i);
        if (i >= k - 1) {
          res[i - k + 1] = nums[que.getFirst()];
        }
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}