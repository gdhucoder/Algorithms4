package ALeetCode.comp.p242;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean checkZeroOnes(String s) {
      int ones = 0, zeros = 0;
      char[] chs = s.toCharArray();
      int i = 0;
      while (i < chs.length) {
        char c = chs[i];
        int j = i + 1;
        if (c == '0') {
          while (j < chs.length && chs[j] == '0') {
            j++;
          }
          zeros = Math.max(zeros, j - i);
        }
        else {
          while (j < chs.length && chs[j] == '1') {
            j++;
          }
          ones = Math.max(ones, j - i);
        }
        i = j;
      }
      return ones > zeros;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.checkZeroOnes("110100010");
    System.out.println();
  }
}
