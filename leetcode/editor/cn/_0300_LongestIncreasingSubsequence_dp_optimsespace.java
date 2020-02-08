//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package leetcode.editor.cn;

public class _0300_LongestIncreasingSubsequence_dp_optimsespace {

  public static void main(String[] args) {
    Solution solution = new _0300_LongestIncreasingSubsequence_dp_optimsespace().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minDistance(String word1, String word2) {
      if (word1.length() == 0)
        return word2.length();
      if (word2.length() == 0)
        return word1.length();
      char[] a = word1.toCharArray();
      char[] b = word2.toCharArray();
      int m = a.length + 1, n = b.length + 1, pre;
      int[] dp = new int[n];
      for (int j = 1; j < n; j++) {
        dp[j] = j;
      }
      for (int i = 1; i < m; i++) {
        pre = dp[0];
        dp[0] = i;
        for (int j = 1; j < n; j++) {
          int temp = dp[j];
          if (a[i - 1] == b[j - 1]) {
            dp[j] = pre;
          } else {
            dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
          }
          pre = temp;
        }
      }
      return dp[n - 1];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}