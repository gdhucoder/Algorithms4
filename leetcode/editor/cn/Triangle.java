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

public class Triangle {

  public static void main(String[] args) {
    Solution solution = new Triangle().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
      if (triangle == null || triangle.size() == 0) {
        return 0;
      }
      // 只需要记录每一层的最小值即可
      int[] dp = new int[triangle.size() + 1];

      for (int i = triangle.size() - 1; i >= 0; i--) {
        List<Integer> curTr = triangle.get(i);
        for (int j = 0; j < curTr.size(); j++) {
          //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
          dp[j] = Math.min(dp[j], dp[j + 1]) + curTr.get(j);
        }
      }
      return dp[0];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}