//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0212_WordSearchIi_bruteforce {

  public static void main(String[] args) {
    Solution solution = new _0212_WordSearchIi_bruteforce().new Solution();
    Boolean[][] mark = new Boolean[10][9];
    Arrays.fill(mark, new Boolean(false));
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private int m;
    private int n;
    private char[][] board;
    private boolean[][] mark;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
      if (board == null && board.length == 0)
        return Collections.emptyList();
      init(board);
      List<String> res = new ArrayList<>();
      for (String word : words) {
        resetMark();
        if (_findWord(board, word)) {
          res.add(word);
        }
      }

      return res;
    }

    private boolean _findWord(char[][] board, String word) {

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (_dfs(i, j, 0, word)) {
            return true;
          }
        }
      }
      return false;
    }


    private boolean _dfs(int i, int j, int pos, String word) {
      if (pos == word.length() - 1 && board[i][j] == word.charAt(pos)) {
        return true;
      }

      if (board[i][j] == word.charAt(pos)) {
        mark[i][j] = true;
        for (int k = 0; k < 4; k++) {
          int nextI = i + dir[k][0];
          int nextJ = j + dir[k][1];
          if (_isValid(nextI, nextJ) && !mark[nextI][nextJ]) {
            //System.out.println(word.charAt(pos));
            if (_dfs(nextI, nextJ, pos + 1, word)) {
              return true;
            }
          }
        }
        mark[i][j] = false;
      }

      return false;
    }

    private boolean _isValid(int i, int j) {
      return i >= 0 && i < m & j >= 0 && j < n;
    }

    private void resetMark() {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mark[i][j] = false;
        }
      }
    }

    private void init(char[][] board) {
      this.m = board.length;
      this.n = board[0].length;
      this.board = board;
      this.mark = new boolean[m][n];
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}