package ALeetCode.comp.p225;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minCharacters(String a, String b) {
      int[] chsa = new int[26];
      int[] chsb = new int[26];
      int maxa = 0, maxb = 0;
      for (char c : a.toCharArray()) {
        chsa[c - 'a']++;
        maxa = Math.max(c - 'a', maxa);
      }
      for (char c : b.toCharArray()) {
        chsb[c - 'a']++;
        maxb = Math.max(c - 'a', maxb);
      }

      // A 中
      int totalA = 0;
      for (int i = maxb + 1; i < 26; i++) {
        totalA += chsa[i];
      }

      int totalB = 0;
      for (int i = maxa + 1; i < 26; i++) {
        totalB += chsb[i];
      }
      //
      //      System.out.println(totalA);
      //      System.out.println(totalB);

      return Math.min(a.length() - totalA, b.length() - totalB);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minCharacters("dabadd", "cda"));
    System.out.println(s.minCharacters("aba", "caa"));
  }
}
