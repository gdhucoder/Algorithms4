//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    Solution solution = new Permutations().new Solution();
    int[] a = {1, 1, 2};
    solution.permute(a);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> permute(int[] a) {
      List<List<Integer>> res = new ArrayList<>();
      if (a.length == 0) return res;
      boolean[] used = new boolean[a.length];
      Deque<Integer> path = new ArrayDeque<>();
      dfs(0, a, used, path, res);
      return res;
    }

    private void dfs(int level, int[] a, boolean[] used, Deque<Integer> path,
        List<List<Integer>> res) {
      if (path.size() == a.length) {
        res.add(new ArrayList<>(path));
        System.out.println(path);
        return;
      }
      for (int i = 0; i < a.length; i++) {
        if (!used[i]) {
          //          if (i > 0 && a[i - 1] == a[i] && !used[i - 1]) continue;
          if (i > 0 && a[i - 1] == a[i] && !used[i - 1]) continue;
          used[i] = true;
          path.addLast(a[i]);
          dfs(level + 1, a, used, path, res);
          path.removeLast();
          used[i] = false;
        }
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}