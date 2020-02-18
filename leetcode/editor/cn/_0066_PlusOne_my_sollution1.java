//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.Arrays;
import tools.PrintUtil;

public class _0066_PlusOne_my_sollution1 {

  public static void main(String[] args) {
    Solution solution = new _0066_PlusOne_my_sollution1().new Solution();
    int[] a = {9, 9, 9};
    int[] ret = solution.plusOne(a);
    PrintUtil.show(ret);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] plusOne(int[] a) {
      int pos = a.length - 1;
      while (pos >= 0 && a[pos] == 9) {
        pos--;
      }
      if (pos >= 0) {
        a[pos] += 1;
        if (pos < a.length - 1) Arrays.fill(a, pos + 1, a.length, 0);
        return a;
      }
      int[] result = new int[a.length + 1];
      result[0] = 1;
      return result;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}