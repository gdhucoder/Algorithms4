//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 动态规划


package leetcode.editor.cn;

import tools.PrintUtil;

public class _Interview_08_11_CoinLcci {

  public static void main(String[] args) {
    //  先注意重复 和 遍历的顺序
    Solution solution = new _Interview_08_11_CoinLcci().new Solution();
    solution.waysToChange(10);
    //      1 1 1 1 1 1 1 1 1 1 1
    //      1 1 1 1 1 2 2 2 2 2 3
    //      1 1 1 1 1 2 2 2 2 2 4
    //      1 1 1 1 1 2 2 2 2 2 4
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int waysToChange(int n) {
      int[] dp = new int[n + 1];
      int[] cents = {1, 5, 10, 25};
      int mod = 1000000007;
      dp[0] = 1;
      for (int cent : cents) {
        for (int i = cent; i <= n; i++) {
          dp[i] = (dp[i] + dp[i - cent]) % mod;
        }
        PrintUtil.show(dp);
      }
      return dp[n];
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}