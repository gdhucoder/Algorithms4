package ALeetCode.comp.p191;

import ALeetCode.tools.Util;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int maxArea(int h, int w, int[] hc, int[] vc) {
      int[] hinv = getInv(hc, h);
      int[] vinv = getInv(vc, w);
      Arrays.sort(hinv);
      Arrays.sort(vinv);
      return (int) ((long) hinv[hinv.length - 1] * vinv[vinv.length - 1] % 1000000007);
    }

    private int[] getInv(int[] hc, int end) {
      int hlen = hc.length;
      int[] hinv = new int[hlen + 1];
      Arrays.sort(hc);
      hinv[0] = hc[0];
      for (int i = 1; i < hlen; i++) {
        hinv[i] = hc[i] - hc[i - 1];
      }
      hinv[hlen] = end - hc[hlen - 1];
      return hinv;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int h = 1000000000;
    int w = 1000000000;
    List<int[]> arrs = Util.readAllIntArray("ALeetCode/comp/prblemtemplates/in.txt");
    int[] hc = arrs.get(0);
    int[] hv = arrs.get(1);
    System.out.println(s.maxArea(h, w, hc, hv));
  }
}
