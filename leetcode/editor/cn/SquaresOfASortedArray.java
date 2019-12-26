//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

public class SquaresOfASortedArray {

  public static void main(String[] args) {
    Solution solution = new SquaresOfASortedArray().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] sortedSquares(int[] A) {
      if (A == null || A.length == 0)
        return null;
      // -5, -2, -1, 0, 1,3
      //
      int[] res = new int[A.length];
      int lo = 0, hi = A.length - 1;
      for (int i = res.length - 1; i >= 0; i--) {
        if (Math.abs(A[lo]) > Math.abs(A[hi])) {
          res[i] = A[lo] * A[lo];
          lo++;
        } else {
          res[i] = A[hi] * A[hi];
          hi--;
        }
      }
      return res;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}