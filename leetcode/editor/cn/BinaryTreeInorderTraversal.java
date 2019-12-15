//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

  public static void main(String[] args) {
    Solution solution = new BinaryTreeInorderTraversal().new Solution();
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ret = new ArrayList<>();
      inorder(ret, root);
      return ret;
    }

    private void inorder(List<Integer> ret, TreeNode n) {
      if (n == null) {
        return;
      }
      //if (n.left != null)
      inorder(ret, n.left);
      ret.add(n.val);
      //if (n.right != null)
      inorder(ret, n.right);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}