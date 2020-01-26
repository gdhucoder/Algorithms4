package ALeetCode.comp.p173;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
        int maxDistance) {
      if (restaurants.length == 0)
        return Collections.emptyList();

      Arrays.sort(restaurants, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
          if (a[1] != b[1]) {
            return b[1] - a[1];
          } else {
            return b[0] - a[0];
          }
        }
      });
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < restaurants.length; i++) {
        int[] r = restaurants[i];
        if (r[3] <= maxPrice && r[4] <= maxDistance) {
          if (veganFriendly == 1) {
            if (r[2] == 1) {
              res.add(r[0]);
            }
          } else {
            res.add(r[0]);
          }
        }
      }

//      PrintUtil.show(restaurants);
//      System.out.println(res);
      return res;

    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
    int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3},
        {5, 1, 1, 15, 1}};
    int veganFriendly = 0, maxPrice = 50, maxDistance = 10;
    s.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);

  }
}
