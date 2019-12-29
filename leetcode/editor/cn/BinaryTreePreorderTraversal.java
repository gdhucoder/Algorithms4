//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.editor.cn;

import edu.princeton.cs.algs4.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

  public static void main(String[] args) {
    Solution solution = new BinaryTreePreorderTraversal().new Solution();
    Stack<Integer> stack = new Stack<>();
    stack.push(null);
    stack.push(null);
    System.out.println(stack.size());
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<Integer> preorderTraversal(TreeNode node) {
      List<Integer> list = new LinkedList<Integer>();
      Deque<TreeNode> rights = new ArrayDeque<>();
      while (node != null) {
        list.add(node.val);
        if (node.right != null) {
          rights.push(node.right);
        }
        node = node.left;
        if (node == null && !rights.isEmpty()) {
          node = rights.pop();
        }
      }
      return list;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}