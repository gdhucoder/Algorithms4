//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 438 👎 0


package leetcode.editor.cn;

public class _0264_UglyNumberIi {

  public static void main(String[] args) {
    Solution solution = new Solution();
    //    System.out.println(solution.nthUglyNumber(10));
    System.out.println(solution.nthUglyNumber(103));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  static class Solution {

    public Ug ug = new Ug();

    public int nthUglyNumber(int n) {
      return ug.nums[n - 1];
    }

    class Ug {

      int[] nums = new int[1690];
      int i2, i3, i5 = 0;

      Ug() {
        nums[0] = 1;
        for (int i = 1; i < 1690; i++) {
          nums[i] = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
          if (nums[i] == nums[i2] * 2) i2++;
          if (nums[i] == nums[i3] * 3) i3++;
          if (nums[i] == nums[i5] * 5) i5++;
        }
      }
      //leetcode submit region end(Prohibit modification and deletion)
    }


  }
}