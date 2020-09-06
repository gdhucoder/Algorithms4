package ALeetCode.comp.p205;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String modifyString(String s) {
      char[] chs = s.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < chs.length; i++) {
        if (chs[i] == '?') {
          char choose = chooseOne(chs, i);
          chs[i] = choose;
        }
      }
      return new String(chs);
    }

    private char chooseOne(char[] chs, int pos) {
      char res = 'a';
      char[] set = new char[26];
      for (int j = 0; j < set.length; j++) {
        set[j] = (char) ('a' + j);
      }
      for (int i = 0; i < set.length; i++) {
        if (pos == 0 && pos + 1 < chs.length) {
          if (chs[pos + 1] != set[i]) {
            return set[i];
          }
        }
        else if (pos == chs.length - 1 && pos - 1 >= 0) {
          if (chs[pos - 1] != set[i]) {
            return set[i];
          }
        }
        else if (pos - 1 >= 0 && pos + 1 < chs.length && chs[pos - 1] != set[i]
            && chs[pos + 1] != set[i]) {
          return set[i];
        }
      }
      return res;
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
    //    System.out.println(s.modifyString("?"));
    //    System.out.println(s.modifyString("?zs?"));
    System.out.println(s.modifyString("??????"));
  }
}
