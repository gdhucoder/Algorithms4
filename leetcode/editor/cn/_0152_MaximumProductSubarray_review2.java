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

public class _0152_MaximumProductSubarray_review2 {

  public static void main(String[] args) {
    Solution solution = new _0152_MaximumProductSubarray_review2().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int maxProduct(int[] nums) {
      if (nums == null || nums.length == 0)
        return 0;
      int[][] dp = new int[2][2];
      dp[0][0] = dp[0][1] = nums[0];
      int res = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int x = i & 1, y = (i - 1) & 1;
        int max = dp[y][0] * nums[i], min = dp[y][1] * nums[i];
        dp[x][0] = max(max, min, nums[i]);
        dp[x][1] = min(max, min, nums[i]);
        res = Math.max(res, dp[x][0]);
      }
      return res;
    }

    private int max(int a, int b, int c) {
      int max = a;
      if (max < b) {
        max = b;
      }
      if (max < c) {
        max = c;
      }
      return max;
    }

    private int min(int a, int b, int c) {
      int min = a;
      if (min > b) {
        min = b;
      }
      if (min > c) {
        min = c;
      }
      return min;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}