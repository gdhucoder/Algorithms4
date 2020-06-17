//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limi
//t 。 
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 数组 Sliding Window


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

  public static void main(String[] args) {
    Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int longestSubarray(int[] A, int limit) {
      Deque<Integer> maxd = new ArrayDeque<>();
      Deque<Integer> mind = new ArrayDeque<>();
      int i = 0, j;
      for (j = 0; j < A.length; ++j) {
        while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
        while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
        maxd.add(A[j]);
        mind.add(A[j]);
        if (maxd.peek() - mind.peek() > limit) {
          if (maxd.peek() == A[i]) maxd.poll();
          if (mind.peek() == A[i]) mind.poll();
          ++i;
        }
      }
      return j - i;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}