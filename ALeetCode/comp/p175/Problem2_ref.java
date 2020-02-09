package ALeetCode.comp.p175;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2_ref {

  static class Solution {

    public int minSteps(String s, String t) {
      if (s.length() == 0)
        return 0;
      int[] ch = new int[26];
      for (char c : s.toCharArray()) {
        ch[c - 'a']++;
      }

      for (char c : t.toCharArray()) {
        ch[c - 'a']--;
      }
      int result = 0;
      for (int i = 0; i < ch.length; i++) {
        result += Math.max(0, ch[i]);
      }
      return result;
    }
  }

  public static void main(String[] args) {
    Solution solt = new Solution();
    String s = "leetcode", t = "practice";
    int result = solt.minSteps(s, t);
    assert result == 5;
    System.out.println(result);

    s = "bab";
    t = "aba";
    result = solt.minSteps(s, t);
    assert result == 1;
    System.out.println(result);
  }
}
