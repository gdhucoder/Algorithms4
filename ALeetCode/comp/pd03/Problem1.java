package ALeetCode.comp.pd03;

import java.util.HashMap;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String sortString(String s) {
      char[] chars = s.toCharArray();
      int[] words = new int[26];
      int count = 0;
      for (char ch : chars) {
        words[ch - 'a']++;
        count++;
      }
      String res = "";
      while (count > 0) {
        for (int i = 0; i < 26; i++) {
          if (words[i] > 0) {
            res += (char) (i + 'a');
            words[i]--;
            count--;
          }
        }

        for (int i = 25; i >= 0; i--) {
          if (words[i] > 0) {
            res += (char) (i + 'a');
            words[i]--;
            count--;
          }
        }
      }

      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String str = "aaaabbbbcccc";
    System.out.println(s.sortString(str));
    String res = "abccbaabccba";
    assert res.equals(s.sortString(str));
    str = "rat";
    res = "art";
    assert res.equals(s.sortString(str));
    HashMap<String, Integer> map = new HashMap<>();
    //    System.out.println(map.con);
  }
}
