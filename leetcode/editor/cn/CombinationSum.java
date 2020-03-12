//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    Solution solution = new CombinationSum().new Solution();
    int[] candidates = {2, 3, 5};
    int target = 8;
    System.out.println(solution.combinationSum(candidates, target));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      helper(0, 0, target, candidates, new LinkedList<>(), res);
      return res;
    }

    private void helper(int sum, int pos, int target, int[] can, List<Integer> path,
        List<List<Integer>> res) {
      if (sum == target) {
        //        System.out.println(path);
        res.add(new ArrayList<>(path));
        return;
      }
      if (sum > target) {
        return;
      }
      for (int i = pos; i < can.length; i++) {
        path.add(can[i]);
        helper(sum + can[i], i, target, can, path, res);
        path.remove(path.size() - 1);
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}