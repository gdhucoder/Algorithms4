//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 260 👎 0


package leetcode.editor.cn;

public class _0415_AddStrings {

  public static void main(String[] args) {
    Solution solution = new _0415_AddStrings().new Solution();
    //    System.out.println(solution.addStrings("134", "7"));
    //    System.out.println(solution.addStrings("9999", "9999"));
    //    System.out.println(solution.addStrings("134", "1244"));
    System.out.println(solution.addStrings("99", "9"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String addStrings(String num1, String num2) {
      if (num1.length() < num2.length()) return addStrings(num2, num1);
      char[] chs1 = num1.toCharArray();
      char[] chs2 = num2.toCharArray();
      int len1 = chs1.length;
      int len2 = chs2.length;
      StringBuilder sb = new StringBuilder();
      int add = 0;
      for (int i = 0; i < len1; i++) {
        int i1 = (chs1[len1 - 1 - i] - '0');
        int i2 = i >= len2 ? 0 : (chs2[len2 - 1 - i] - '0');
        int sum = i1 + i2 + add;
        add = sum / 10;
        sb.append(sum % 10);
      }
      if (add == 1) sb.append(add);
      return sb.reverse().toString();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}