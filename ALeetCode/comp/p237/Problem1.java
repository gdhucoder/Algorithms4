package ALeetCode.comp.p237;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean checkIfPangram(String sentence) {
      int[] cnt = new int[26];
      char[] chs = sentence.toCharArray();
      for (char c : chs) {
        cnt[c - 'a']++;
      }
      for (int n : cnt) {
        if (n == 0) return false;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
