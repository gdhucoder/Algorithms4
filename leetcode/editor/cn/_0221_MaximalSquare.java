//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


package leetcode.editor.cn;

public class _0221_MaximalSquare {

  public static void main(String[] args) {
    Solution solution = new _0221_MaximalSquare().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int maximalSquare(char[][] a) {
      if (a.length == 0) return 0;
      int n = a.length, m = a[0].length;
      int max = 0;
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          if (a[i - 1][j - 1] == '1') {
            dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
            //System.out.println(dp[i][j]);
            max = Math.max(max, dp[i][j]);
          }
        }
      }
      return max * max;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}