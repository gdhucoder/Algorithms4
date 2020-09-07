//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 190 👎 0


package leetcode.editor.cn;

public class _0404_SumOfLeftLeaves {

  public static void main(String[] args) {
    Solution solution = new _0404_SumOfLeftLeaves().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
      dfs(root);
      return sum;
    }

    private void dfs(TreeNode n) {
      if (n == null) return;
      if (n.left != null && (n.left.left == null && n.left.right == null)) {
        sum += n.left.val;
      }
      dfs(n.left);
      dfs(n.right);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}