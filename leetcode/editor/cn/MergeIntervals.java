//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public static void main(String[] args) {
    Solution solution = new MergeIntervals().new Solution();
    int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(solution.merge(a));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[][] merge(int[][] in) {
      if (in.length == 0) return new int[0][0];
      Arrays.sort(in, Comparator.comparingInt(a -> a[0]));
      List<int[]> res = new ArrayList<>();
      res.add(new int[]{in[0][0], in[0][1]});
      for (int i = 1; i < in.length; i++) {
        int[] ele = in[i];
        int[] inRes = res.get(res.size() - 1);
        if (inRes[1] >= ele[0] && (inRes[1] < ele[1])) {
          int[] a = res.get(res.size() - 1);
          a[1] = ele[1];
          continue;
        }
        res.add(new int[]{in[i][0], in[i][1]});
      }
      return res.toArray(new int[0][]);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}