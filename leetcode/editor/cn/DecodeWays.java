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
      if (s.equals("0")) return 0;
      if (s.indexOf("0") == 0) return 0;
      return helper(0, s);
    }

    private int helper(int pos, String s) {
      if (pos >= s.length()) {
        return 1;
      }
      int step1 = 0;
      if (pos + 1 <= s.length() && Integer.valueOf(s.substring(pos, pos + 1)) > 0)
        step1 = helper(pos + 1, s);
      int step2 = 0;
      if (isValid(s, pos)) step2 = helper(pos + 2, s);
      return step1 + step2;
    }

    private boolean isValid(String s, int pos) {

      if (pos + 2 <= s.length() && s.substring(pos, pos + 2).indexOf("0") != 0) {
        int val = Integer.valueOf(s.substring(pos, pos + 2));
        if (val > 0 && val < 27) {
          return true;
        }
      }
      return false;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}