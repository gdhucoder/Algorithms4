//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 298 👎 0


package leetcode.editor.cn;

public class _0371_SumOfTwoIntegers {

  public static void main(String[] args) {
    System.out.println(1 & 2);
    Solution solution = new _0371_SumOfTwoIntegers().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int getSum(int a, int b) {
      if (a == 0) return b;
      if (b == 0) return a;
      int lower, carrier;
      while (true) {
        lower = a ^ b; // 取低位
        carrier = a & b; // 取高位
        if (carrier == 0) break;
        b = lower;
        a = carrier << 1; // 左移一位
      }
      return lower;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}