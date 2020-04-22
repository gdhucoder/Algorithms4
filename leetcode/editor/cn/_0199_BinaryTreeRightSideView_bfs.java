//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0199_BinaryTreeRightSideView_bfs {

  public static void main(String[] args) {
    Solution solution = new _0199_BinaryTreeRightSideView_bfs().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<Integer> rightSideView(TreeNode root) {
      if (root == null) return Collections.emptyList();
      ArrayDeque<TreeNode> que = new ArrayDeque<>();
      List<Integer> res = new ArrayList<>();
      que.addLast(root);
      while (!que.isEmpty()) {
        int size = que.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = que.removeFirst();
          if (node.left != null) que.addLast(node.left);
          if (node.right != null) que.addLast(node.right);
          if (i == size - 1) res.add(node.val);
        }
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}