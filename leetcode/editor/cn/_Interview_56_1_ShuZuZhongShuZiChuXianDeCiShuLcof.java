//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums <= 10000 
// 
//
// 
//


package leetcode.editor.cn;

public class _Interview_56_1_ShuZuZhongShuZiChuXianDeCiShuLcof {

  public static void main(String[] args) {
    Solution solution = new _Interview_56_1_ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
    int[] a = {1, 2, 10, 4, 1, 4, 3, 3, 11, 11};
    solution.singleNumbers(a);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] singleNumbers(int[] nums) {
      int diff = 0;
      for (int i = 0; i < nums.length; i++) {
        System.out.println(Integer.toBinaryString(nums[i]));
        diff ^= nums[i];
      }
      System.out.println(" diff" + Integer.toBinaryString(diff));
      System.out.println("-diff" + Integer.toBinaryString(-diff));
      diff &= -diff; // 取最后一个1
      System.out.println(Integer.toBinaryString(diff));
      int[] rets = {0, 0};
      for (int i = 0; i < nums.length; i++) {
        if ((nums[i] & diff) == 0) {
          System.out.printf("===============>%d, %10s\n", nums[i], Integer.toBinaryString(nums[i]));
          rets[0] ^= nums[i];
        }
        else {
          System.out.printf("%d, %10s\n", nums[i], Integer.toBinaryString(nums[i]));
          rets[1] ^= nums[i];
        }
      }
      return rets;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}