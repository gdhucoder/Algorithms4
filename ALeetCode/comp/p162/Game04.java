package ALeetCode.comp.p162;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Game04 {

  /**
   * 思路：贪心算法。依次填就是了。试过了用回溯算法，超时了。 https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/
   *
   * @param upper
   * @param lower
   * @param colsum
   * @return
   */
  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int[][] ret = new int[2][colsum.length];
    int upp = 0;
    int low = 0;
    int sum = 0;

    for (int i = 0; i < colsum.length; i++) {
      if (colsum[i] == 2) {
        ret[0][i] = 1;
        ret[1][i] = 1;
        upp++;
        low++;
      }
      sum += colsum[i];
    }
    if (sum != (upper + lower) || upp > upper || low > lower) {
      return new ArrayList<>();
    } else {
      upp = upper - upp;
      low = lower - low;
      for (int i = 0; i < colsum.length; i++) {
        if (colsum[i] == 1 && upp != 0) {
          ret[0][i] = 1;
          upp--;
        } else if (colsum[i] == 1 && low != 0) {
          ret[1][i] = 1;
          low--;
        }
      }
      List<List<Integer>> ans = new ArrayList<>();

      for (int i = 0; i < 2; i++) {
        List<Integer> l = new ArrayList<>();
        for (int j = 0; j < colsum.length; j++) {
          l.add(ret[i][j]);
        }
        ans.add(l);
      }
      return ans;
    }
  }

  public static void main(String[] args) {
//    9
//    2
//        [0,1,2,0,0,0,0,0,2,1,2,1,2]

    //    int[] cols = {2,0,2,1,1,2,2,0,1,1,1,0,0,0,0,2,1,2,2,2,1,1,0,0,0,0,1,2,1,0,1,0,2,0,0,0,0,2,1,1,2,1,1,0,0,1,0,0,1,1,2,0,1,1,1,2,1,0,0,1,1,1,2,2,1,0,0,1,1,1,0,2,1,2,1,0,1,2,0,2,2,1,0,1,1,1,2,0,0,0,1,2,2,0,0,1,1,2,1,2};
    int[] cols = {0, 1, 2, 0, 0, 0, 0, 0, 2, 1, 2, 1, 2};
//    4
//    7
//        [2,1,2,2,1,1,1]

//    5
//    5
//        [2,1,2,0,1,0,1,2,0,1]
    Game04 g = new Game04();
    System.out.println("result: ");
    System.out.println("ans :" + g.reconstructMatrix(9, 2, cols));
    System.out.println(1);
  }
}
