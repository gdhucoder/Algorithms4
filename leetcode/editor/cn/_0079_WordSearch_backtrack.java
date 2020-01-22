//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false. 
// Related Topics 数组 回溯算法

package leetcode.editor.cn;

public class _0079_WordSearch_backtrack {

  public static void main(String[] args) {
    Solution solution = new _0079_WordSearch_backtrack().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {


    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m;
    private int n;
    private String word;

    public boolean exist(char[][] board, String word) {
      if (board == null && board.length == 0)
        return false;

      m = board.length;
      n = board[0].length;
      this.word = word;
      boolean[][] mark = new boolean[m][n];

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (_dfs(i, j, 0, board, mark)) {
            return true;
          }
        }
      }

      return false;
    }

    private boolean _dfs(int i, int j, int pos, char[][] board, boolean[][] mark) {
      if (pos == word.length() - 1 && board[i][j] == word.charAt(pos))
        return true;

      if (board[i][j] == word.charAt(pos)) {
        mark[i][j] = true;
        for (int k = 0; k < 4; k++) {
          int nextI = i + direction[k][0];
          int nextJ = j + direction[k][1];
          if (isValidArea(nextI, nextJ) && !mark[nextI][nextJ]) {
            if ((_dfs(nextI, nextJ, pos + 1, board, mark))) {
              return true;
            }
          }
        }
        mark[i][j] = false;
      }
      return false;

    }

    private boolean isValidArea(int i, int j) {
      return i < m && j < n && i >= 0 && j >= 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}