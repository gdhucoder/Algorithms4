package ALeetCode.comp.p190;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import leetcode.editor.cn.TreeNode;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int pseudoPalindromicPaths(TreeNode root) {
      List<List<Integer>> paths = new ArrayList<>();
      helper(root, new ArrayList<>(), paths);
      int count = 0;
      for (List<Integer> p : paths) {
        if (isPali(p)) {
          count++;
        }
      }
      return count;
    }

    private void helper(TreeNode node, List<Integer> path, List<List<Integer>> paths) {
      if (node == null) {
        return;
      }
      path.add(node.val);
      if (node.left == null && node.right == null) {
        //        System.out.println(new ArrayList<>(path));
        paths.add(new ArrayList<>(path));
      }
      helper(node.left, path, paths);
      helper(node.right, path, paths);
      path.remove(path.size() - 1);
    }

    private boolean isPali(List<Integer> nums) {
      boolean res = true;
      Map<Integer, Integer> map = new HashMap<>();
      for (Integer n : nums) {
        map.put(n, map.getOrDefault(n, 0) + 1);
      }
      int oneCount = 0;
      for (Entry<Integer, Integer> e : map.entrySet()) {
        if (e.getValue() % 2 != 0) {
          oneCount++;
        }
      }
      return oneCount <= 1;
    }

  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    //    Integer[] nums = {1, 2, 1};
    Integer[] nums = {6, 6, 6};
    // 1 1 2
    // 1 1 2 2
    // 2,3,3
    // 3 2 3
    // 3,3,2
    // 2 2 3 4 4
    System.out.println(s.isPali(Arrays.asList(nums)));
    System.out.println(4 ^ 4);
    System.out.println(4 ^ 4 ^ 3 ^ 2 ^ 2);
    System.out.println(4 ^ 4 ^ 3 ^ 1 ^ 2);

  }
}
