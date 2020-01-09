//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找

package leetcode.editor.cn;

public class _0704_BinarySearch {

  public static void main(String[] args) {
    Solution solution = new _0704_BinarySearch().new Solution();
    int[] a = {1, 2, 2, 2, 3};
    System.out.println(solution.search(a, 2));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int search(int[] nums, int target) {
      int lo = 0;
      int hi = nums.length - 1;
      while (lo < hi) {
        int mid = (hi + lo + 1) >>> 1;
        if (nums[mid] > target) {
          hi = mid - 1;
        } else {
          lo = mid;
        }
        System.out.println(hi + "," + lo);
      }
      if (nums[lo] == target) {
        return lo;
      }
      return -1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}