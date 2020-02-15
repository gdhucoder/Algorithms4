//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找

package leetcode.editor.cn;

public class _0145_FindMinimumInRotatedSortedArray_binarysearch {

  public static void main(String[] args) {
    Solution solution = new _0145_FindMinimumInRotatedSortedArray_binarysearch().new Solution();
    //    int[] a = {4, 5, 6, 7, 0, 1, 2};
    int[] a = {2, 1};
    System.out.println("pos; " + solution.findMin(a));
    System.out.println(2 + (8 >> 1));
  }

  //leetcode submit region begin(Prohibit modification and deletion)

  class Solution {

    public int findMin(int[] a) {
      return a[find(a, 0, a.length - 1)];
    }

    private int find(int[] a, int left, int right) {
      while (left < right) {
        int mid = left + ((right - left) >> 1);
        if (a[mid] < a[left] && a[mid] < a[right]) {
          return find(a, left, mid);
        }
        else if (a[mid] >= a[left] && a[mid] > a[right]) {
          return find(a, mid + 1, right);
        }
        else if (a[mid] >= a[left] && a[mid] < a[right]) {
          return find(a, left, mid - 1);
        }
        else if (a[mid] == a[left]) {
          return mid;
        }
      }
      return left;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}