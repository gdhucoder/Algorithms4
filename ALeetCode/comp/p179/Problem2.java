package ALeetCode.comp.p179;

import java.util.Arrays;
import java.util.Comparator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public String rankTeams(String[] votes) {
      if (votes.length == 0) return "";
      int voteLen = votes[0].length();
      int[][] counts = new int[26][voteLen + 1];

      for (int i = 0; i < voteLen; i++) {
        counts[votes[0].charAt(i) - 'A'][0] = votes[0].charAt(i);
      }
      for (String v : votes) {
        for (int i = 0; i < v.length(); i++) {
          counts[v.charAt(i) - 'A'][i + 1]++;
        }
      }
      PrintUtil.show(counts);
      Arrays.sort(counts, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          for (int i = 1; i < o1.length; i++) {
            if (o1[i] == o2[i]) continue;
            return -(o1[i] - o2[i]);
          }
          return 0;
        }
      });
      PrintUtil.show(counts);
      String res = "";
      for (int i = 0; i < voteLen; i++) {
        res += (char) counts[i][0];
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] votes = {"AXYB", "AYXB", "AXYB", "AYXB"};
    System.out.println(s.rankTeams(votes));
  }
}
