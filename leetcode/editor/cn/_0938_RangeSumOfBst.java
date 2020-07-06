//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。 
//
// 二叉搜索树保证具有唯一的值。 
//
// 
//
// 示例 1： 
//
// 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//输出：32
// 
//
// 示例 2： 
//
// 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数量最多为 10000 个。 
// 最终的答案保证小于 2^31。 
// 
// Related Topics 树 递归


package leetcode.editor.cn;

public class _0938_RangeSumOfBst {

  public static void main(String[] args) {
    Solution solution = new _0938_RangeSumOfBst().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
      preOrder(root, L, R);
      return sum;
    }

    private void preOrder(TreeNode node, int L, int R) {
      if (node == null) return;
      if (node.val >= L) preOrder(node.left, L, R);
      if (node.val >= L && node.val <= R) sum += node.val;
      if (node.val <= R) preOrder(node.right, L, R);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}