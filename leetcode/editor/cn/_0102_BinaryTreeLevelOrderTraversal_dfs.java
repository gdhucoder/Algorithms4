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
import java.util.List;

public class _0102_BinaryTreeLevelOrderTraversal_dfs {

  public static void main(String[] args) {
    Solution solution = new _0102_BinaryTreeLevelOrderTraversal_dfs().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode node) {
      if (node == null) return res;
      dfs(0, node);
      return res;
    }

    private void dfs(int level, TreeNode node) {
      if (node == null) return;
      // System.out.println(level+","+node.val);
      if (res.size() == level) {
        List<Integer> list = new ArrayList<>();
        res.add(list);
      }
      res.get(level).add(node.val);
      dfs(level + 1, node.left);
      dfs(level + 1, node.right);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}