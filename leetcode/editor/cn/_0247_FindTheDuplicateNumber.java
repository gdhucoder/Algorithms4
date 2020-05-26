//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找

package leetcode.editor.cn;

public class _0247_FindTheDuplicateNumber {

  public static void main(String[] args) {
    Solution solution = new _0247_FindTheDuplicateNumber().new Solution();
    int[] a = {2, 1, 4, 3, 2};
    solution.findDuplicate(a);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  public class Solution {

    public int findDuplicate(int[] nums) {
      int left = 0, right = nums.length - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        System.out.println(mid);
        int count = numBelow(nums, mid);
        if (count > mid) right = mid;
        else left = mid + 1;
        System.out.printf("%d, %d, %d\n", count, left, right);
      }
      return left;
    }

    public int numBelow(int[] nums, int target) {
      int result = 0;
      for (int num : nums) if (num <= target) result++;
      return result;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}