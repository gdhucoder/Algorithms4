package ALeetCode.comp.p185;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int minNumberOfFrogs(String croakOfFrogs) {
      char[] ga = new char[5];
      //      croak
      ga[0] = 'c';
      ga[1] = 'r';
      ga[2] = 'o';
      ga[3] = 'a';
      ga[4] = 'k';
      StringBuilder sb = new StringBuilder(croakOfFrogs);
      int pre = 0;
      int res = 0;
      for (char c : ga) {
        int idx = sb.indexOf(String.valueOf(c));
        if (idx > pre) {
          pre = idx;
          sb.replace(idx, idx + 1, "");
          if (c == 'k') res++;
        }
        else {
          return -1;
        }

      }
      return res;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
