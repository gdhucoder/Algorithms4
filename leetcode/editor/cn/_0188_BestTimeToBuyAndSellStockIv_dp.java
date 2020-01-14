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

public class _0188_BestTimeToBuyAndSellStockIv_dp {

  public static void main(String[] args) {
    Solution solution = new _0188_BestTimeToBuyAndSellStockIv_dp().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int maxProfit(int k, int[] prices) {
      if (prices == null || prices.length == 0)
        return 0;
      /**
       当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II
       的贪心方法解决可以大幅提升时间性能，如果不用这个贪心，有个testCase过不去，会报空间超
       限
       */
      if (k >= prices.length / 2)
        return greedy(prices);
      int[][][] mp = new int[prices.length][2][k + 1];
      for (int i = 0; i <= k; i++) {
        // 第 1 天买入 - 卖出循环 K 次之后不再买入，所以初始值为 0
        mp[0][0][i] = 0;
        // 第 1 天买入 - 卖出循环 K 次之后又买入，所以初始值为 -prices[0]
        mp[0][1][i] = -prices[0];
      }
      for (int i = 1; i < prices.length; i++) {
        for (int j = 0; j <= k; j++) {
          mp[i][0][j] =
              j != 0 ? Math.max(mp[i - 1][1][j - 1] + prices[i], mp[i - 1][0][j]) : mp[i - 1][0][j];
          mp[i][1][j] = Math.max(mp[i - 1][0][j] - prices[i], mp[i - 1][1][j]);
        }
      }
      int max = Integer.MIN_VALUE;
      for (int i = 0; i <= k; i++)
        max = Math.max(max, mp[prices.length - 1][0][i]);
      return max;
    }

    private int greedy(int[] prices) {
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