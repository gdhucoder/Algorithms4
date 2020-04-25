//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0046_Permutations {

  public static void main(String[] args) {
    Solution solution = new _0046_Permutations().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> permute(int[] a) {
      if (a.length == 0) return Collections.emptyList();
      List<List<Integer>> res = new ArrayList<>();
      dfs(0, a, new boolean[a.length], new ArrayList<>(), res);
      return res;
    }

    private void dfs(int level, int[] a, boolean[] used, List<Integer> path,
        List<List<Integer>> res) {
      if (level == a.length) {
        res.add(new ArrayList<>(path));
        return;
      }
      for (int i = 0; i < a.length; i++) {
        if (!used[i]) {
          path.add(a[i]);
          used[i] = true;
          dfs(level + 1, a, used, path, res);
          path.remove(path.size() - 1);
          used[i] = false;
        }
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}