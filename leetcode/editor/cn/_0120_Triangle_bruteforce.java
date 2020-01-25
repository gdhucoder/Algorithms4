//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0120_Triangle_bruteforce {

  public static void main(String[] args) {
    Solution solution = new _0120_Triangle_bruteforce().new Solution();
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(5, 6, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(solution.minimumTotal(triangle));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
      if (triangle == null || triangle.size() == 0)
        return 0;
      _dfs(triangle, 0, 0, 0, "");
      return 0;
    }

    private void _dfs(List<List<Integer>> triangle, int i, int j, int sum, String path) {
      // terminator
      if (i == triangle.size() - 1) {
        sum += triangle.get(i).get(j);
        path += (triangle.get(i).get(j)) + "#" + sum;
        System.out.println(path);
        return;
      }

      // process
      path += triangle.get(i).get(j) + "->";
      sum += triangle.get(i).get(j);

      // drill down
      _dfs(triangle, i + 1, j, sum, path);
      _dfs(triangle, i + 1, j + 1, sum, path);
      // clear status
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}