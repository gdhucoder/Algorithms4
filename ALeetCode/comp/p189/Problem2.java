package ALeetCode.comp.p189;

import java.util.Arrays;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public String arrangeWords(String text) {
      if (text.length() == 0) return "";
      String[] ar = text.split(" ");
      Arrays.sort(ar, (a, b) -> (a.length() - b.length()));
      //      PrintUtil.show(ar);
      StringBuilder sb = new StringBuilder(text.length());
      for (String s : ar) {
        sb.append(s.toLowerCase()).append(' ');
      }
      sb.setLength(sb.length() - 1);
      sb.setCharAt(0, (char) (sb.charAt(0) < 'a' ? sb.charAt(0) : sb.charAt(0) - 32));
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String text = "Keep calm and code on";
    System.out.println(s.arrangeWords(text));
    s.arrangeWords(text);
    System.out.println((int) 'a');
    System.out.println((int) 'A');
  }
}
