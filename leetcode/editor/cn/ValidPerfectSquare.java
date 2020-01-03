//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn;

public class ValidPerfectSquare {

  public static void main(String[] args) {
    Solution solution = new ValidPerfectSquare().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isPerfectSquare(int num) {
      if (num < 0)
        return false;
      if (num == 1)
        return true;
      int lo = 0;
      int hi = num / 2;
      while (lo <= hi) {
        int mid = (hi - lo) / 2 + lo;
        if (mid < num / mid) {
          lo = mid + 1;
        } else if (mid > num / mid) {
          hi = mid - 1;
        } else if (mid == num / mid && num % mid == 0) {
          return true;
        } else {
          return false;
        }
      }
      return false;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}