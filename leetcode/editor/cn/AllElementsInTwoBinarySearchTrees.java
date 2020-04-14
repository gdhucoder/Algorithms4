//给你 root1 和 root2 这两棵二叉搜索树。 
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
// 
//
// 示例 3： 
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
// 
//
// 示例 4： 
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 5000 个节点。 
// 每个节点的值在 [-10^5, 10^5] 之间。 
// 
// Related Topics 排序 树


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

  public static void main(String[] args) {
    Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> l1 = new LinkedList<>();
      getEles(root1, l1);
      List<Integer> l2 = new LinkedList<>();
      getEles(root2, l2);
      List<Integer> res = new LinkedList<>();
      System.out.println(res.size());
      int n1 = 0, n2 = 0;
      while (n1 < l1.size() && n2 < l2.size()) {
        if (l1.get(n1) < l2.get(n2)) {
          res.add(l1.get(n1));
          n1++;
        }
        else {
          res.add(l2.get(n2));
          n2++;
        }
      }
      if (n1 == l1.size()) res.addAll(l2.subList(n2, l2.size()));
      if (n2 == l2.size()) res.addAll(l1.subList(n1, l1.size()));
      return res;
    }

    private void getEles(TreeNode node, List<Integer> list) {
      if (node == null) return;
      getEles(node.left, list);
      list.add(node.val);
      getEles(node.right, list);
    }
  }

  //leetcode submit region end(Prohibit modification and deletion)

}