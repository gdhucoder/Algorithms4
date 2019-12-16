//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

  public static void main(String[] args) {
    Solution solution = new FindLargestValueInEachTreeRow().new Solution();
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<Integer> largestValues(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      if (root == null) {
        return list;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        int max = Integer.MIN_VALUE;
        int sz = queue.size();
        for (int i = 0; i < sz; i++) {
          TreeNode node = queue.poll();
          if (node.val > max) {
            max = node.val;
          }
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
        list.add(max);
      }
      return list;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}