package ALeetCode.comp.p190;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
      String[] a = sentence.split(" ");
      int res = -1;
      for (int i = 0; i < a.length; i++) {
        if (a[i].startsWith(searchWord)) {
          res = i + 1;
          break;
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
