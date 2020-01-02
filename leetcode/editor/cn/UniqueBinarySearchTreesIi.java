//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesIi {

  public static void main(String[] args) {
    Solution solution = new UniqueBinarySearchTreesIi().new Solution();
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public List<TreeNode> generateTrees(int n) {
      if (n == 0)
        return Collections.emptyList();
      return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
      List<TreeNode> ans = new ArrayList<>();
      if (start > end) {
        ans.add(null);
        return ans;
      }
      if (start == end) {
        TreeNode tree = new TreeNode(start);
        ans.add(tree);
        return ans;
      }

      for (int i = start; i <= end; i++) {
        List<TreeNode> leftTrees = getAns(start, i - 1);
        List<TreeNode> rightTrees = getAns(i + 1, end);
        for (TreeNode leftTree : leftTrees) {
          for (TreeNode rightTree : rightTrees) {
            TreeNode root = new TreeNode(i);
            root.left = leftTree;
            root.right = rightTree;
            ans.add(root);
          }
        }
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}