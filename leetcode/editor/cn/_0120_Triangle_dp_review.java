//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

import java.util.List;

public class _0120_Triangle_dp_review {

  public static void main(String[] args) {
    Solution solution = new _0120_Triangle_dp_review().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
      if (triangle == null || triangle.size() == 0)
        return 0;
      int m = triangle.size();
      int[] dp = new int[m + 1];
      // process
      // 主要逻辑优化到一行搞定
      for (int i = m - 1; i >= 0; i--) {
        List<Integer> line = triangle.get(i);
        for (int j = 0; j < line.size(); j++) {
          dp[j] = Math.min(dp[j], dp[j + 1]) + line.get(j);
        }
      }
      return dp[0];
    }

    public int minimumTotal_2(List<List<Integer>> triangle) {
      if (triangle == null || triangle.size() == 0)
        return 0;
      int m = triangle.size();
      int n = triangle.get(m - 1).size();
      int[] dp = new int[n];
      // init state
      for (int i = 0; i < n; i++) {
        dp[i] = triangle.get(m - 1).get(i);
      }

      //
      for (int i = m - 2; i >= 0; i--) {
        for (int j = n - 1; j >= 1; j--) {
          int ele = triangle.get(i).get(j);
          dp[i] = Math.min(dp[j], dp[j - 1]) + ele;
        }
      }

      return dp[0];
    }

    public int minimumTotal_1(List<List<Integer>> triangle) {
      if (triangle == null || triangle.size() == 0)
        return 0;
      int m = triangle.size();
      int n = triangle.get(m - 1).size();
      int min = Integer.MAX_VALUE;
      int[][] dp = new int[m][n];
      dp[0][0] = triangle.get(0).get(0);
      for (int i = 1; i < triangle.size(); i++) {
        List<Integer> line = triangle.get(i);
        for (int j = 0; j < line.size(); j++) {
          if (j == line.size() - 1)
            dp[i][j] = dp[i - 1][j - 1] + line.get(j);
          else if (j == 0)
            dp[i][j] = dp[i - 1][j] + line.get(j);
          else
            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + line.get(j);
        }
      }

      for (int i = 0; i < n; i++) {
        min = Math.min(min, dp[m - 1][i]);
      }
      return min;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}