//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

public class _0152_MaximumProductSubarray_DPV1 {

  public static void main(String[] args) {
    Solution solution = new _0152_MaximumProductSubarray_DPV1().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int maxProduct(int[] nums) {
      if (nums == null || nums.length == 0)
        return 0;
      int[][] dp = new int[nums.length][2];
      dp[0][0] = nums[0];
      dp[0][1] = nums[0];
      int res = nums[0];
      for (int i = 1; i < nums.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][1] * nums[i], Math.max(dp[i - 1][0] * nums[i], nums[i]));
        dp[i][1] = Math.min(dp[i - 1][1] * nums[i], Math.min(dp[i - 1][0] * nums[i], nums[i]));
        res = Math.max(res, dp[i][0]);
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}