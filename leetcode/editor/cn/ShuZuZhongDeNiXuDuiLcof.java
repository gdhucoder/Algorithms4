//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//


package leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {

  public static void main(String[] args) {
    Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private int[] temp;

    public int reversePairs(int[] a) {
      temp = new int[a.length * 100];
      return sort(a, 0, a.length - 1);
    }

    private int sort(int[] a, int lo, int hi) {
      if (lo >= hi) return 0;
      int mid = lo + (hi - lo) / 2;
      int left = sort(a, lo, mid);
      int right = sort(a, mid + 1, hi);
      int afterMerge = merge(a, lo, mid, hi);
      return left + right + afterMerge;
    }

    private int merge(int[] a, int lo, int mid, int hi) {
      int i = lo;
      int j = mid + 1;
      for (int k = lo; k <= hi; k++) {
        temp[k] = a[k];
      }
      int count = 0;
      for (int k = lo; k <= hi; k++) {
        if (j > hi) a[k] = temp[i++];
        else if (i > mid) a[k] = temp[j++];
        else if (temp[j] < temp[i]) {
          count += mid - i + 1;
          a[k] = temp[j++];
        }
        else a[k] = temp[i++];
      }
      return count;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}