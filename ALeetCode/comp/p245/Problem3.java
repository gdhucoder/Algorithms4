package ALeetCode.comp.p245;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public boolean makeEqual(String[] words) {
      int[] cnts = new int[26];
      for (String s : words) {
        for (char c : s.toCharArray()) {
          cnts[c - 'a']++;
        }
      }
      for (int cnt : cnts) {
        if (cnt % (words.length) != 0) {
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
