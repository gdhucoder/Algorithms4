//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
// 
// Related Topics 动态规划

package leetcode.editor.cn;

public class _0188_BestTimeToBuyAndSellStockIv_review_dp {

  public static void main(String[] args) {
    Solution solution = new _0188_BestTimeToBuyAndSellStockIv_review_dp().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int maxProfit(int k, int[] prices) {
      if (prices.length <= 1)
        return 0;
      if (k >= prices.length / 2) {
        return greedy(prices);
      }
      int n = prices.length;
      int max_k = k + 1;
      int[][][] dp = new int[n][max_k][2];
      for (int i = 0; i < n; i++) {
        for (int d = 1; d < max_k; d++) {
          if (i == 0) {
            dp[i][d][0] = 0;
            dp[i][d][1] = -prices[i];
            continue;
          }
          dp[i][d][0] = Math.max(dp[i - 1][d][0], dp[i - 1][d][1] + prices[i]);
          dp[i][d][1] = Math.max(dp[i - 1][d][1], dp[i - 1][d - 1][0] - prices[i]);
        }
      }
      return dp[n - 1][k][0];
    }

    public int greedy(int[] prices) {
      int max = 0;
      for (int i = 1; i < prices.length; ++i) {
        if (prices[i] > prices[i - 1])
          max += prices[i] - prices[i - 1];
      }
      return max;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}