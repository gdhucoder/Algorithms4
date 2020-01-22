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
    char[][] board =
        {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

    String word = "ABCCED";
    System.out.println(solution.exist(board, word));


  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private int m;
    private int n;
    private char[][] board;
    private boolean[][] mark;
    private String word;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
      if (board == null || board.length == 0)
        return false;
      init(board, word);
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (_dfs(i, j, 0)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean _dfs(int i, int j, int pos) {
      if (pos == word.length() - 1 && board[i][j] == word.charAt(pos)) {
        return true;
      }
      if (board[i][j] == word.charAt(pos)) {
        mark[i][j] = true;
        for (int k = 0; k < 4; k++) {
          int nextI = i + dir[k][0];
          int nextJ = j + dir[k][1];
          if (isValid(nextI, nextJ) && !mark[nextI][nextJ]) {
            if (_dfs(nextI, nextJ, pos + 1)) {
              return true;
            }
          }
        }
        mark[i][j] = false;
      }
      return false;
    }

    private boolean isValid(int i, int j) {
      return 0 <= i && i < m && 0 <= j && j < n;
    }

    private void init(char[][] board, String word) {
      this.m = board.length;
      this.n = board[0].length;
      this.board = board;
      this.word = word;
      this.mark = new boolean[m][n];
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}