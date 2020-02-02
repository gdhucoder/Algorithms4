package ALeetCode.comp.p177;

import java.util.ArrayList;
import java.util.List;
import leetcode.editor.cn.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/ Created by HuGuodong on
 * 12/8/19.
 */
public class Problem3 {

  static class Solution {

    List<Integer> sums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
      int all = dfs(root);
      long ret = 0;
      int mod = 1000000007;
      for (int v : sums) {
        ret = Math.max(ret, (long) v * (all - v));
      }
      return (int) (ret % mod);
    }

    int dfs(TreeNode root) {
      if (root == null)
        return 0;
      int s = root.val + dfs(root.left) + dfs(root.right);
      sums.add(s);
      return s;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
