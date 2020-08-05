//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 445 👎 0


package leetcode.editor.cn;

public class _0067_AddBinary {

  public static void main(String[] args) {
    Solution solution = new _0067_AddBinary().new Solution();
    System.out.println(solution.addBinary("1111", "1111"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String addBinary(String a, String b) {
      char[] as = a.toCharArray();
      char[] bs = b.toCharArray();
      StringBuilder sb = new StringBuilder();
      char cnt = '0';
      for (int i = 0; i < Math.min(as.length, bs.length); i++) {
        char pa = as[as.length - 1 - i];
        char pb = bs[bs.length - 1 - i];
        if (pa == '1' && pb == '1') {
          if (cnt == '1') {
            sb.append("1");
            cnt = '1';
          }
          else {
            sb.append("0");
            cnt = '1';
          }
        }
        else if (pa == '1' || pb == '1') {
          if (cnt == '1') {
            sb.append("0");
          }
          else {
            sb.append("1");
          }
        }
        else {
          if (cnt == '1') {
            sb.append("1");
            cnt = '1';
          }
          else {
            sb.append("0");
          }
        }
      }
      int minLen = Math.min(as.length, bs.length);
      char[] heads = as.length > bs.length ? as : bs;
      for (int i = heads.length - minLen - 1; i >= 0; i--) {
        if (heads[i] == '1') {
          if (cnt == '1') {
            sb.append("0");
          }
          else {
            sb.append("1");
          }
        }
        else {
          sb.append("0");
        }
      }

      if (cnt == '1') {
        sb.append("1");
      }
      System.out.println(cnt);
      return sb.reverse().toString();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}