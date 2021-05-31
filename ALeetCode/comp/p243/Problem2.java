package ALeetCode.comp.p243;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public String maxValue(String n, int x) {
      char[] chs = n.toCharArray();
      int len = chs.length;
      StringBuffer sb = new StringBuffer();
      boolean isTail = true;
      int i = 0;
      if (chs[0] == '-') {
        sb.append(chs[0]);
        for (i = 1; i < len; i++) {
          if (x < chs[i] - '0') {
            sb.append(x);
            isTail = false;
            break;
          }
          sb.append(chs[i]);
        }
      }
      else {
        for (i = 0; i < len; i++) {
          if (x > chs[i] - '0') {
            sb.append(x);
            isTail = false;
            break;
          }
          sb.append(chs[i]);
        }
      }
      if (isTail) {
        sb.append(x);
      }
      else {
        sb.append(n, i, len);
      }

      return sb.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
