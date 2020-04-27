//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


package leetcode.editor.cn;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] a, int target) {
            int left = 0, right = a.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (target == a[mid]) {
                    return mid;
                }
                else if (a[left] <= a[mid]) {
                    if (a[left] <= target && target <= a[mid]) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                else {
                    if (a[mid] <= target && target <= a[right]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }

            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}