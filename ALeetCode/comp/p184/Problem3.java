package ALeetCode.comp.p184;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public String entityParser(String text) {
      //      双引号：字符实体为 &quot; ，对应的字符是 " 。
      //      单引号：字符实体为 &apos; ，对应的字符是 ' 。
      //      与符号：字符实体为 &amp; ，对应对的字符是 & 。
      //      大于号：字符实体为 &gt; ，对应的字符是 > 。
      //      小于号：字符实体为 &lt; ，对应的字符是 < 。
      //      斜线号：字符实体为 &frasl; ，对应的字符是 / 。

      Map<String, Character> map = new HashMap<>();
      map.put("&quot;", '"');
      map.put("&apos;", '\'');
      map.put("&amp;", '&');
      map.put("&gt;", '>');
      map.put("&lt;", '<');
      map.put("&frasl;", '/');
      char[] chs = text.toCharArray();
      int start = 0, end = 0, in_text_start = 0, in_text_end = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < chs.length; i++) {
        sb.append(chs[i]);
        if (chs[i] == '&') {
          start = sb.lastIndexOf("&");
          in_text_start = i;
        }
        else if (chs[i] == ';') {
          end = sb.lastIndexOf(";");
          in_text_end = i;
          String symbol = String.valueOf(chs, in_text_start, in_text_end - in_text_start + 1);
          if (map.containsKey(symbol)) {
            sb.delete(start, end + 1);
            sb.append(map.get(symbol));
          }
        }
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    String res = s.entityParser("x &gt; y &amp;&amp; x &lt; y is always false");
    System.out.println(res.equals("x > y && x < y is always false"));
    //    System.out.println(s.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
  }
}
