//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

package leetcode.editor.cn;

import tools.PrintUtil;

public class KthLargestElementInAnArray {

  public static void main(String[] args) {
    Solution solution = new KthLargestElementInAnArray().new Solution();
//    [3,2,1,5,6,4]
//    2
    int[] a = {3, 2, 1, 5, 6, 4};
    int k = 2;
    System.out.println(solution.findKthLargest(a, k));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    int target;

    public int findKthLargest(int[] nums, int k) {
      target = nums.length - k;
      help(nums, 0, nums.length - 1);
      return nums[target];
    }

    void help(int[] nums, int start, int end) {

      if (start >= end) {
        return;
      }
      PrintUtil.show(nums);
      System.out.println(start + "," + end);
      int left = start;
      int right = end;
      int pivot = nums[(start + end) / 2];

      while (left < right) {
        while (left <= right && nums[left] < pivot)
          left++;
        while (left <= right && nums[right] > pivot)
          right--;
        if (left <= right) {
          swap(left, right, nums);
          left++;
          right--;
        }
      }

      if (target >= left) {
        help(nums, left, end);
      }
      if (target <= right) {
        help(nums, start, right);
      }
      return;
    }

    void swap(int i, int j, int[] nums) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

//leetcode submit region end(Prohibit modification and deletion)

}