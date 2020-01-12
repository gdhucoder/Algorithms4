//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null)
        return Collections.emptyList();
      List<List<Integer>> res = new LinkedList<>();
      Queue<TreeNode> que = new LinkedList<>();
      que.add(root);
      while (!que.isEmpty()) {
        int size = que.size();
        List<Integer> lvl = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          TreeNode node = que.poll();
          lvl.add(que.poll().val);
          if (node.right != null)
            que.add(node.right);
          if (node.left != null)
            que.add(node.left);
        }
        res.add(lvl);
      }
      return res;
    }
  }

  //leetcode submit region end(Prohibit modification and deletion)
}