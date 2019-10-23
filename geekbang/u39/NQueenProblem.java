package geekbang.u39;

/**
 * Created by HuGuodong on 2019-10-22.
 */
public class NQueenProblem {

  int[] result = new int[8];

  public void cac8Queens(int row) {
    if (row == 8) {
      printQueens();
      return; // 如果不写return，会检测 row = 8 代到下面的循环中
    }
    for (int col = 0; col < 8; col++) {
      if (isOk(row, col)) { // 检查是否满足
        result[row] = col; // 第row行放置第col列
        cac8Queens(row + 1); // 考察下一行
      }
    }
  }

  public boolean isOk(int row, int col) {
    int leftUp = col - 1, rightUp = col + 1; // 检查左右对角线位置
    for (int r = row - 1; r >= 0; r--) {// 检查每一行，检查放过棋子的行
      if (result[r] == col) // 第i行的col有棋子么
        return false;
      if (leftUp >= 0)
        if (result[r] == leftUp) // 左对角线位置有棋子么
          return false;
      if (rightUp < 8)
        if (result[r] == rightUp) // 右对角线位置有棋子么？
          return false;
      leftUp--;
      rightUp++;
    }
    return true;
  }

  public void printQueens() {
    System.out.println("Found:===============================");
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        if (result[r] == c) {
          System.out.print("Q ");
        } else {
          System.out.print("* ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    NQueenProblem p = new NQueenProblem();
    p.cac8Queens(0);
  }


}
