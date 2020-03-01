//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    Solution solution = new Subsets().new Solution();
    int[] a = {1, 2, 3};
    solution.subsets(a);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      Arrays.sort(nums);
      backtrack(list, new ArrayList<>(), nums, 0);
      return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,
        int start) {

      //      System.out.println(tempList);
      list.add(new ArrayList<>(tempList));
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        System.out.printf("%2d, %2d ", start, i);
        System.out.println(tempList);

        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }

  }
  //leetcode submit region end(Prohibit modification and deletion)

}