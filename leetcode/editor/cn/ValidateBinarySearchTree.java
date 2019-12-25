//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.Stack;

public class ValidateBinarySearchTree {

  public static final String[] IPs = new String[]{"xxx", "xxx"};

  public static void main(String[] args) {
    Solution solution = new ValidateBinarySearchTree().new Solution();
    IPs[0] = "1";
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {


    public boolean isValidBST(TreeNode root) {
      if (root == null)
        return true;
      Stack<TreeNode> stack = new Stack<>();
      TreeNode pre = null;
      while (root != null || !stack.isEmpty()) {
        while (root != null) {
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        if (pre != null && root.val <= pre.val)
          return false;
        pre = root;
        root = root.right;
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}