package ALeetCode.comp.p165;

/**
 * Created by HuGuodong on 12/1/19.
 */
public class Problem1 {

  static class Solution {

    public String tictactoe(int[][] moves) {
      String draw = "Draw";
      String pending = "Pending";
      String a_wins = "A";
      String b_wins = "B";

      int[][] board = new int[3][3];
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          board[i][j] = -1;
        }
      }

      for (int i = 0; i < moves.length; i++) {
        if (i % 2 == 0) { // A -> X
          board[moves[i][0]][moves[i][1]] = 1;
        } else { // B -> O
          board[moves[i][0]][moves[i][1]] = 0;
        }
      }

      // jude
      // row
      for (int i = 0; i < 3; i++) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
          if (board[i][0] == 1) {
            return a_wins;
          } else if (board[0][0] == 0) {
            return b_wins;
          }
        }
      }

      // col
      for (int i = 0; i < 3; i++) {
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
          if (board[i][0] == 1) {
            return a_wins;
          } else if (board[0][0] == 0) {
            return b_wins;
          }
        }
      }

      // dir
      if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        if (board[0][0] == 1) {
          return a_wins;
        } else if (board[0][0] == 0) {
          return b_wins;
        }
      }

      if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        if (board[0][0] == 1) {
          return a_wins;
        } else if (board[0][0] == 0) {
          return b_wins;
        }
      }

      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j] == -1) {
            return pending;
          }
        }
      }

      return draw;
    }
  }

}
