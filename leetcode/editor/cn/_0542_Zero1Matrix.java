//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0542_Zero1Matrix {

  public static void main(String[] args) {
    Solution solution = new _0542_Zero1Matrix().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[][] updateMatrix(int[][] matrix) {
      int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      int n = matrix.length, m = matrix[0].length;
      boolean[][] visited = new boolean[n][m];
      int[][] res = new int[n][m];
      Deque<int[]> que = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 0) {
            que.addLast(new int[]{i, j});
            visited[i][j] = true;
          }
        }
      }
      while (!que.isEmpty()) {
        int[] point = que.removeFirst();
        int i = point[0], j = point[1];
        for (int k = 0; k < 4; k++) {
          int ni = i + dirs[k][0];
          int nj = j + dirs[k][1];
          if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj]) {
            res[ni][nj] = res[i][j] + 1;
            que.addLast(new int[]{ni, nj});
            visited[ni][nj] = true;
          }
        }
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}