package ALeetCode.comp.p166;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {


  static class Solution {

    class Pair {

      int val;
      int idx;

      public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
      }

      @Override
      public String toString() {
        return "Pair{" +
            "val=" + val +
            ", idx=" + idx +
            '}';
      }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
      int n = groupSizes.length;
      List<List<Integer>> ans = new ArrayList<>();
      if (n == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        ans.add(list);
        return ans;
      }
      Pair[] pairs = new Pair[n];
      for (int i = 0; i < n; i++) {
        pairs[i] = new Pair(groupSizes[i], i);
      }
      Arrays.sort(pairs, (a, b) -> a.val - b.val);
      PrintUtil.show(pairs);
      int i = 0;
      while (i < n) {
        List<Integer> list = new ArrayList<>();
        list.add(pairs[i].idx);
        int j = i + 1;
        if (list.size() == pairs[i].val) {
          ans.add(list);
          i = j;
          continue;
        }
        while (list.size() < pairs[i].val && j < n) {
          list.add(pairs[j].idx);
          j++;
        }
        i = j;
        ans.add(list);

      }

      // PrintUtil.show(ans);

      return ans;
    }

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] group = {1, 1, 1, 1};
    s.groupThePeople(group);
    System.out.println();
  }
}
