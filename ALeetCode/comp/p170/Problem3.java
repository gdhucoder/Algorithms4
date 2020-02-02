package ALeetCode.comp.p170;

import leetcode.editor.cn.TreeNode;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
      if (root == null)
        return null;
      return delete(root, target);

    }

    private TreeNode delete(TreeNode node, int target) {

      // leaf
      if (node.val == target && node.left == null && node.right == null) {
        return null;
      }
      if (node.left != null) {
        node.left = delete(node.left, target);
      }
      if (node.right != null) {
        node.right = delete(node.right, target);
      }
      return node;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
