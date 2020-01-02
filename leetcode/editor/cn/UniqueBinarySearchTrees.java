//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

package leetcode.editor.cn;

public class UniqueBinarySearchTrees {

  public static void main(String[] args) {
    Solution solution = new UniqueBinarySearchTrees().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int numTrees(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      for (int level = 2; level <= n; level++) {
        for (int root = 1; root <= level; root++) {
          dp[level] += dp[root - 1] * dp[level - root];
        }
      }
      return dp[n];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}