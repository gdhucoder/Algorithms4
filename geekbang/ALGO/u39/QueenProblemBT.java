package geekbang.ALGO.u39;

/**
 * Created by HuGuodong on 2019/11/8.
 */
public class QueenProblemBT {

  int[] result = new int[8];

  public void calcQueen(int row) {
    if (row == 8) {
      printQueen();
      return;
    }
    for (int c = 0; c < 8; c++) {
      if (isOK(row, c)) {
        result[row] = c;
        calcQueen(row + 1);
      }
    }
  }

  public void printQueen() {

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
    System.out.println("==========================");
  }

  private boolean isOK(int row, int column) {
    int leftUp = column - 1;
    int rightUp = column + 1;
    for (int r = row - 1; r >= 0; r--) {
      if (result[r] == column) {
        return false;
      }
      if (leftUp >= 0) {
        if (result[r] == leftUp) { // 左上
          return false;
        }
      }
      if (rightUp < 8) {
        if (result[r] == rightUp) { // 右下
          return false;
        }
      }
      --leftUp;
      ++rightUp;
    }
    return true;
  }

  public static void main(String[] args) {
    QueenProblemBT q = new QueenProblemBT();
    q.calcQueen(0);
  }
}
