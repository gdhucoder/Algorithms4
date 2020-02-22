//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
  class Solution {

    public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;
      Queue<Node> que = new LinkedList<>();
      que.add(root);
      while (!que.isEmpty()) {
        int size = que.size();
        List<Integer> level = new LinkedList<>();
        for (int i = 0; i < size; i++) {
          Node n = que.poll();
          System.out.println(n.val);
          level.add(n.val);
          que.addAll(n.children);
        }
        res.add(level);
      }
      return res;
    }

    private class Node {

      public int val;
      public List<Node> children;

      public Node() {}

      public Node(int _val) {
        val = _val;
      }

      public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
      }
    }

    ;
  }
  //leetcode submit region end(Prohibit modification and deletion)

}