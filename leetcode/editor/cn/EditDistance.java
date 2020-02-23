//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 示例 1: 
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释: 
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2: 
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释: 
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

public class EditDistance {

  public static void main(String[] args) {
    Solution solution = new EditDistance().new Solution();
    System.out.println(solution.minDistance("a", "b"));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minDistance(String word1, String word2) {
      char[] a = word1.toCharArray();
      char[] b = word2.toCharArray();
      int m = a.length + 1, n = b.length + 1;
      int[][] dp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == 0) {
            dp[i][j] = j;
            continue;
          }
          if (j == 0) {
            dp[i][j] = i;
            continue;
          }
          dp[i][j] = Math.min(dp[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 0 : 1),
              Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
        }
      }
      return dp[m - 1][n - 1];
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}