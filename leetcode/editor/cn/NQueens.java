//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

  public static void main(String[] args) {
    Solution solution = new NQueens().new Solution();
    List<List<String>> res = solution.solveNQueens(4);
    System.out.println(res);
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<String>> solveNQueens(int n) {
      List<List<String>> res = new ArrayList<>();
      String[] board = new String[n];
      helper(n, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(),
          board, res);
      return res;
    }

    private void helper(int n, int row, Set<Integer> cols, Set<Integer> xySum, Set<Integer> xyDiff,
        String[] board, List<List<String>> res) {
      if (row == n) {
        res.add(Arrays.asList(board.clone()));
        return;
      }

      for (int col = 0; col < n; col++) {
        if (cols.contains(col) || xySum.contains(row + col) || xyDiff.contains(row - col)) {
          continue;
        }
        char[] rows = new char[n];
        Arrays.fill(rows, '.');
        rows[col] = 'Q';
        board[row] = new String(rows);
        cols.add(col);
        xySum.add(row + col);
        xyDiff.add(row - col);
        helper(n, row + 1, cols, xySum, xyDiff, board, res);
        cols.remove(col);
        xySum.remove(row + col);
        xyDiff.remove(row - col);
      }
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}