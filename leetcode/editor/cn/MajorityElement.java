//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package leetcode.editor.cn;

public class MajorityElement {

  public static void main(String[] args) {
    Solution solution = new MajorityElement().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int majorityElement(int[] nums) {
      //
      return findMajority(nums, 0, nums.length - 1);
    }

    private int findMajority(int[] nums, int lo, int hi) {
      if (lo == hi) {
        return nums[lo];
      }
      int mid = (hi - lo) / 2 + lo;
      int left = findMajority(nums, lo, lo + mid);
      int right = findMajority(nums, mid + 1, hi);
      if (left == right)
        return left;
      int leftCount = countInRange(nums, left, lo, hi);
      int rightCount = countInRange(nums, right, lo, hi);
      return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
      int cnt = 0;
      for (int i = lo; i <= hi; i++) {
        if (num == nums[i])
          cnt++;
      }
      return cnt;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}