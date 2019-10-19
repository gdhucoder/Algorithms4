package ALeetCode;

import java.util.Arrays;
import java.util.Comparator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019-10-19.
 */
public class P0452 {

  /**
   * 452. Minimum Number of Arrows to Burst Balloons
   *
   * @return
   */
  public static int solution(int[][] points) {
    return intervalSchedule(points);
  }

  public static void sort(int[][] a) {
    Arrays.sort(a, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
  }

  public static int intervalSchedule(int[][] intervs) {
    sort(intervs);
    int x_end = intervs[0][1];
    int count = 1;
    for (int i = 1; i < intervs.length; i++) {
      int x_start = intervs[i][0];
      if (x_start > x_end) {
        count++;
        x_end = intervs[i][1];
      } else {
      }

    }
    return count;
  }

  public static void main(String[] args) {
    int[][] a = {{1, 5}, {2, 4}, {3, 5}, {5, 9}, {6, 8}, {8, 10}};
    PrintUtil.show(a);
  }


}
