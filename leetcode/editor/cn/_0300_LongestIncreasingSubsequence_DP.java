//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package leetcode.editor.cn;

import tools.PrintUtil;

public class _0300_LongestIncreasingSubsequence_DP {

  public static void main(String[] args) {
    Solution solution = new _0300_LongestIncreasingSubsequence_DP().new Solution();
    int[] a = {10, 9, 2, 5, 3, 7, 101};
    solution.lengthOfLIS(a);
//    10 9 2 5 3 7 101
//    1 1 1 2 2 3 4
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int lengthOfLIS(int[] nums) {
      if (nums.length == 0)
        return 0;
      int[] dp = new int[nums.length];
      dp[0] = 1;
      int result = 1;
      for (int i = 1; i < nums.length; i++) {
        int max = 0;
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j])
            max = Math.max(dp[j], max);
        }
        dp[i] = max + 1;
        result = Math.max(result, dp[i]);
      }
      PrintUtil.show(nums);
      PrintUtil.show(dp);
      return result;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}