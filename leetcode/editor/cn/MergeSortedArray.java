//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import tools.PrintUtil;

public class MergeSortedArray {

  public static void main(String[] args) {
    Solution solution = new MergeSortedArray().new Solution();
    int[] a = {2, 5, 6, 0, 0,};
    int[] b = {4, 8};
    solution.merge(a, 3, b, 2);
    PrintUtil.show(a);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

      int pos = nums1.length - 1;
      m--;
      n--;
      while (pos >= 0 && m >= 0 && n >= 0) {
        if (nums1[m] > nums2[n]) {
          nums1[pos] = nums1[m];
          m--;
        } else {
          nums1[pos] = nums2[n];
          n--;
        }
        pos--;
      }
      while (n >= 0) {
        nums1[pos--] = nums2[n--];
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}