//给定两个整数 A 和 B，返回任意字符串 S，要求满足： 
//
// 
// S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母； 
// 子串 'aaa' 没有出现在 S 中； 
// 子串 'bbb' 没有出现在 S 中。 
// 
//
// 
//
// 示例 1： 
//
// 输入：A = 1, B = 2
//输出："abb"
//解释："abb", "bab" 和 "bba" 都是正确答案。
// 
//
// 示例 2： 
//
// 输入：A = 4, B = 1
//输出："aabaa" 
//
// 
//
// 提示： 
//
// 
// 0 <= A <= 100 
// 0 <= B <= 100 
// 对于给定的 A 和 B，保证存在满足要求的 S。 
// 
// Related Topics 贪心算法


package leetcode.editor.cn;

public class StringWithoutAaaOrBbb {

  public static void main(String[] args) {
    Solution solution = new StringWithoutAaaOrBbb().new Solution();
    System.out.println(solution.strWithout3a3b(4, 1));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String strWithout3a3b(int A, int B) {
      StringBuilder sb = new StringBuilder(A + B);
      while (A > 0 || B > 0) {
        if (A - 2 >= B && B > 0) {
          sb.append("a".repeat(2));
          sb.append("b".repeat(1));
          A -= 2;
          B -= 1;
        }
        else if (B - 2 >= A && A > 0) {
          sb.append("b".repeat(2));
          sb.append("a".repeat(1));
          B -= 2;
          A -= 1;
        }
        else if (A > B) {
          sb.append("a");
          A--;
        }
        else {
          sb.append("b");
          B--;
        }
      }
      return sb.toString();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}