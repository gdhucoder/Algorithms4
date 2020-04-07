//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

public class DecodeWays {

  public static void main(String[] args) {
    Solution solution = new DecodeWays().new Solution();
    System.out.println(solution.numDecodings(
        "9355141842519423434975558424574331479338913773268525913972842463395324957127519863135646135786662832"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int numDecodings(String s) {
      if (s.length() == 0) return 0;
      int[] dp = new int[s.length() + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) == '0' ? 0 : 1;
      for (int i = 2; i < dp.length; i++) {
        int fisrt = Integer.valueOf(s.substring(i - 1, i));
        int second = Integer.valueOf(s.substring(i - 2, i));
        if (fisrt >= 1 && fisrt <= 9) dp[i] += dp[i - 1];
        if (second >= 10 && second <= 26) dp[i] += dp[i - 2];
      }
      return dp[s.length()];
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}