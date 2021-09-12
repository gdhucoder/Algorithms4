package ALeetCode.comp.p258;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public String reversePrefix(String word, char ch) {
      int pos = word.indexOf(ch);
      if (pos != -1) {
        String pre = word.substring(0, pos + 1);
        pre = reverse(pre);
        return pre + word.substring(pos + 1, word.length());
      }
      else {
        return word;
      }
    }

    private String reverse(String pre) {
      char[] temp = new char[pre.length()];
      for (int i = 0; i < temp.length; i++) {
        temp[i] = pre.charAt(pre.length() - i - 1);
      }
      return new String(temp);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
