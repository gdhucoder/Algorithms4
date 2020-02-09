package ALeetCode.comp.p175;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minSteps(String s, String t) {
      if (s.length() == 0)
        return 0;
      int[] freq_s = toCharArr(s);
      int[] freq_t = toCharArr(t);
      int result = 0;
      for (int i = 0; i < freq_s.length; i++) {
        result += Math.abs(freq_s[i] - freq_t[i]);
      }
      return result / 2;

    }

    private int[] toCharArr(String s) {
      int[] freq = new int[26];
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        freq[chars[i] - 'a']++;
      }
      return freq;
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
