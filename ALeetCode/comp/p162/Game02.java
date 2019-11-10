package ALeetCode.comp.p162;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Game02 {

  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int[][] ret = new int[2][colsum.length];
    List<List<Integer>> ansList = new ArrayList<>();
    choose(0, 0, 0, upper, lower, colsum, ret, ansList, false);
    return ansList.size() >= 2 ? ansList.subList(0, 2) : ansList;
  }

  private static List<List<Integer>> cloneToList(int[][] ret, List<List<Integer>> ansList) {
    int[][] temp = ret.clone();
    System.out.println("temp");
//    PrintUtil.show(temp);
    for (int i = 0; i < 2; i++) {
      List<Integer> l = new ArrayList<>();
      for (int j = 0; j < temp[0].length; j++) {
        l.add((Integer) temp[i][j]);
      }
      ansList.add(l);
    }
    return ansList;
  }

  public static void choose(int idx, int cupper, int culower, int upper, int lower, int[] colsum,
      int[][] ret, List<List<Integer>> ansList, boolean found) {
    if (cupper == upper && culower == lower && idx == colsum.length) {
//      System.out.println("found: " + idx);
      found = true;
      //PrintUtil.show(ret);
      cloneToList(ret, ansList);

      return;
    } else if ((cupper > upper || culower > lower) || (idx >= colsum.length)) {
      return;
    } else if (ansList.size() >= 2) {
      return;
    } else if (found) {
      return;
    }
    if (colsum[idx] == 2) {
      ret[0][idx] = 1;
      ret[1][idx] = 1;
      choose(idx + 1, cupper + 1, culower + 1, upper, lower, colsum, ret, ansList, found);
    } else if (colsum[idx] == 1) {
      ret[0][idx] = 1;
      ret[1][idx] = 0;
      choose(idx + 1, cupper + 1, culower, upper, lower, colsum, ret, ansList, found);
      ret[0][idx] = 0;
      ret[1][idx] = 1;
      choose(idx + 1, cupper, culower + 1, upper, lower, colsum, ret, ansList, found);
    } else {
      ret[0][idx] = 0;
      ret[1][idx] = 0;
      choose(idx + 1, cupper, culower, upper, lower, colsum, ret, ansList, found);
    }


  }

  public static void main(String[] args) {
    Game02 g = new Game02();
    int[] cols = {2, 0, 2, 1, 1, 2, 2, 0, 1, 1, 1, 0, 0, 0, 0, 2, 1, 2, 2, 2, 1, 1, 0, 0, 0, 0, 1,
        2, 1, 0, 1, 0, 2, 0, 0, 0, 0, 2, 1, 1, 2, 1, 1, 0, 0, 1, 0, 0, 1, 1, 2, 0, 1, 1, 1, 2, 1, 0,
        0, 1, 1, 1, 2, 2, 1, 0, 0, 1, 1, 1, 0, 2, 1, 2, 1, 0, 1, 2, 0, 2, 2, 1, 0, 1, 1, 1, 2, 0, 0,
        0, 1, 2, 2, 0, 0, 1, 1, 2, 1, 2};
//    4
//    7
//        [2,1,2,2,1,1,1]

//    5
//    5
//        [2,1,2,0,1,0,1,2,0,1]
    System.out.println("result: ");
    System.out.println("ans :" + g.reconstructMatrix(52, 82, cols));
    System.out.println(1);
//    System.out.println(ans);
  }
}
