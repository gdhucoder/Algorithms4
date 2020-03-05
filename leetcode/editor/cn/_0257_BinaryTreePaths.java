//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0257_BinaryTreePaths {

  public static void main(String[] args) {
    Solution solution = new _0257_BinaryTreePaths().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    private class Pair {

      TreeNode node;
      String path;

      Pair(TreeNode n, String path) {
        this.node = n;
        this.path = path;
      }
    }

    public List<String> binaryTreePaths(TreeNode node) {
      List<String> res = new ArrayList<>();
      if (node == null) return res;
      Deque<Pair> stack = new ArrayDeque();
      stack.addLast(new Pair(node, "" + node.val));
      while (!stack.isEmpty()) {
        Pair p = stack.removeLast();
        TreeNode left = p.node.left, right = p.node.right;
        if (left == null && right == null) res.add(p.path);
        if (left != null) stack.addLast(new Pair(left, p.path + "->" + left.val));
        if (right != null) stack.addLast(new Pair(right, p.path + "->" + right.val));
      }
      return res;
    }


  }
  //leetcode submit region end(Prohibit modification and deletion)

}