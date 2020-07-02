//给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。 
//
// 完成所有替换操作后，请你返回这个数组。 
//
// 
//
// 示例： 
//
// 
//输入：arr = [17,18,5,4,6,1]
//输出：[18,6,6,6,1,-1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i] <= 10^5 
// 
// Related Topics 数组


package leetcode.editor.cn;

public class _1299_ReplaceElementsWithGreatestElementOnRightSide {

  public static void main(String[] args) {
    Solution solution = new _1299_ReplaceElementsWithGreatestElementOnRightSide().new Solution();
    solution.replaceElements(new int[]{17, 18, 5, 4, 6, 1});
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] replaceElements(int[] arr) {
      int len = arr.length;
      int[] res = new int[len];
      res[len - 1] = -1;
      int max = Integer.MIN_VALUE;
      for (int i = len - 1; i >= 1; i--) {
        max = Math.max(max, arr[i]);
        res[i - 1] = max;
      }
      //      PrintUtil.show(res);
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}