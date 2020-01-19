//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法

package leetcode.editor.cn;

public class _0037_SudokuSolver_dfs {

  public static void main(String[] args) {
    Solution solution = new _0037_SudokuSolver_dfs().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public void solveSudoku(char[][] board) {
      if (board == null || board.length == 0)
        return;
      solve(board);
    }

    private boolean solve(char[][] board) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] == '.') {
            for (char cur = '1'; cur <= '9'; cur++) {
              if (isValid(board, i, j, cur)) { // try
                board[i][j] = cur; // fill with number
                if (solve(board)) // recursive
                  return true;
                else // recover
                  board[i][j] = '.';
              }
            }
            // tried all.
            return false;
          }
        }
      }
      return true;
    }

    private boolean isValid(char[][] board, int row, int col, char cur) {
      for (int i = 0; i < 9; i++) {
        if (board[row][i] != '.' && board[row][i] == cur)
          return false;
        if (board[i][col] != '.' && board[i][col] == cur)
          return false;
        if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
            && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == cur)
          return false;
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}