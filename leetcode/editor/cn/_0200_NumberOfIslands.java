//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

import edu.princeton.cs.algs4.StdOut;

public class _0200_NumberOfIslands {

  public static void main(String[] args) {
    Solution solution = new _0200_NumberOfIslands().new Solution();

    char[][] island = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
    System.out.println(solution.numIslands(island));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int numIslands(char[][] grid) {
      int[][] d = {{0, 1}, {1, 0}};
      int m = grid.length;
      int n = grid[0].length;
      QuickUnion un = new QuickUnion(grid);
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '0')
            continue;
          for (int k = 0; k < 2; k++) {
            int n_x = i + d[k][0], n_y = j + d[k][1];
            if (isValid(n_x, n_y, m, n) && grid[n_x][n_y] == '1') {
              StdOut.printf("union %2d %2d\n", i * n + j, n_x * n + n_y);
              un.union(i * n + j, n_x * n + n_y);
            }
          }
        }
      }
      return un.count;

    }

    private boolean isValid(int i, int j, int m, int n) {
      return i >= 0 && i < m && j >= 0 && j < n;
    }
  }

  class QuickUnion {

    int[] roots;
    int count = 0;

    public QuickUnion(char[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int N = m * n;

      roots = new int[N];
      for (int i = 0; i < N; i++) {
        if (grid[i / n][i % n] == '1') {
          roots[i] = i;
          count++;
        } else {
          roots[i] = -1;
        }
      }
    }

    public int find(int i) {
      int root = i;
      while (root != roots[root])
        root = roots[root];
      while (i != roots[i]) {
        int tmp = roots[i];
        roots[i] = root;
        i = tmp;
      }
      return root;
    }

    public void union(int p, int q) {
      int pRoot = find(p);
      int qRoot = find(q);
      if (pRoot != qRoot) {
        count--;
        roots[pRoot] = qRoot;
      }


    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}