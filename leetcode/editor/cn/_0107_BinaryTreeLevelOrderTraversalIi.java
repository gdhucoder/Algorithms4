//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 279 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _0107_BinaryTreeLevelOrderTraversalIi {

  public static void main(String[] args) {
    Solution solution = new _0107_BinaryTreeLevelOrderTraversalIi().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      Deque<TreeNode> que = new ArrayDeque<>();
      que.addLast(root);
      LinkedList<List<Integer>> res = new LinkedList<>();
      while (!que.isEmpty()) {
        int size = que.size();
        List<Integer> lvl = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
          TreeNode node = que.removeFirst();
          lvl.add(node.val);
          if (node.left != null) que.addLast(node.left);
          if (node.right != null) que.addLast(node.right);
        }
        res.addLast(lvl);
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}