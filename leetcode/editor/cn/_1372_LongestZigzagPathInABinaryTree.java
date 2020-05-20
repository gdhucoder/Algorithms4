//给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下： 
//
// 
// 选择二叉树中 任意 节点和一个方向（左或者右）。 
// 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。 
// 改变前进方向：左变右或者右变左。 
// 重复第二步和第三步，直到你在树中无法继续移动。 
// 
//
// 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。 
//
// 请你返回给定树中最长 交错路径 的长度。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
//输出：3
//解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
//输出：4
//解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
// 
//
// 示例 3： 
//
// 输入：root = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 50000 个节点。 
// 每个节点的值在 [1, 100] 之间。 
// 
// Related Topics 树 动态规划


package leetcode.editor.cn;

import java.util.HashMap;

public class _1372_LongestZigzagPathInABinaryTree {

  public static void main(String[] args) {
    Solution solution = new _1372_LongestZigzagPathInABinaryTree().new Solution();
    String str = "alaalllll";
    System.out.println(solution.findTheLongestSubstring(str));
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public int findTheLongestSubstring(String s) {
      int res = 0, cur = 0, n = s.length();
      HashMap<Integer, Integer> seen = new HashMap<>();
      seen.put(0, -1);
      for (int i = 0; i < n; ++i) {
        cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
        System.out.printf("char: %c, cur -> %d,cur: %d, i: %d\n", s.charAt(i), cur,
            1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1, i);
        seen.putIfAbsent(cur, i);
        res = Math.max(res, i - seen.get(cur));
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}