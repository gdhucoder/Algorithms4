//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学 
// 👍 164 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class _0263_UglyNumberV2 {

  public static void main(String[] args) {
    Solution solution = new _0263_UglyNumberV2().new Solution();
    System.out.println(solution.isUgly(1));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isUgly(int num) {
      if (num == 0) return false;
      return isUg(num);
    }

    private boolean isUg(int num) {
      List<Integer> factors = Arrays.asList(2, 3, 5);
      for (int f : factors) {
        while (num % f == 0) {
          num /= f;
        }
      }
      return num == 1;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}