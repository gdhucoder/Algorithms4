//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public static void main(String[] args) {
    Solution solution = new _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      Map<Integer, Integer> inordermp = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        inordermp.put(inorder[i], i);
      }
      return helper(0, 0, preorder.length - 1, preorder, inordermp);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder,
        Map<Integer, Integer> inordermp) {
      if (inStart > inEnd || preStart > preorder.length - 1) {
        return null;
      }
      int index = inordermp.get(preorder[preStart]);
      TreeNode root = new TreeNode(preorder[preStart]);
      root.left = helper(preStart + 1, inStart, index - 1, preorder, inordermp);
      root.right = helper(preStart + 1 + (index - inStart), index + 1, inEnd, preorder, inordermp);
      return root;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}