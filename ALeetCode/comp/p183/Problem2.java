package ALeetCode.comp.p183;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int numSteps(String s) {
      int[] bit = new int[s.length() + 1];
      char[] chs = s.toCharArray();
      for (int i = chs.length - 1; i >= 0; i--) {
        if (chs[i] == '0') bit[i + 1] = 0;
        else bit[i + 1] = 1;
      }
      // 01101
      int pos = bit.length - 1;
      int step = 0;

      // odd
      while (pos > 1) {
        if (bit[pos] == 1) {
          bit[pos] = 0;
          step += 1;
          int p = pos - 1;
          //          System.out.println(p);
          while (p > 0) {
            if (bit[p] == 0) {
              bit[p] = 1;
              break;
            }
            else {
              bit[p] = 0;
              p--;
              if (p == 0) bit[0] = 1;
            }
          }
        }
        else {
          pos--;
          step += 1;
        }
      }
      if (bit[0] == 1) step += 1;
      return step;
    }
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    String str = "1101";
    System.out.println(s.numSteps(str));
    str = "10";
    System.out.println(s.numSteps(str));
    str = "1";
    System.out.println(s.numSteps(str));
    str = "11000";
    System.out.println(s.numSteps(str));
  }
}
