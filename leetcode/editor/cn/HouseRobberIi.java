//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


package leetcode.editor.cn;

public class HouseRobberIi {

  public static void main(String[] args) {
    Solution solution = new HouseRobberIi().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int rob(int[] nums) {

      int n = nums.length;
      if (n == 0) return 0;
      if (n == 1) return nums[0];
      if (n == 2) return Math.max(nums[0], nums[1]);
      int max_1 = getMax(nums, 0, n - 1);
      int max_2 = getMax(nums, 1, n);
      return Math.max(max_1, max_2);
    }

    private int getMax(int[] nums, int start, int end) {
      int n = nums.length;
      int[][] dp = new int[n][2];
      dp[start][0] = 0;
      dp[start][1] = nums[0];
      for (int i = start + 1; i < end; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = dp[i - 1][0] + nums[i];
      }
      return Math.max(dp[end - 1][0], dp[end - 1][1]);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}