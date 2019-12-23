//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组

package leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    Solution solution = new LargestRectangleInHistogram().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int largestRectangleArea(int[] heights) {
      int[] a = heights;
      Stack<Integer> stack = new Stack<>();
      stack.push(a[0]);
      for (int i = 0, j = 1; i < a.length && j < a.length; ) {

        int area = Math.max(Math.min(a[i], a[j]) * (j - i + 1), a[j]);
        if (stack.peek() < area) {
          stack.push(area);
        }
      }
      return 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}