package ALeetCode.comp.p234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    private static final String QuestionMark = "?";

    public String evaluate(String s, List<List<String>> knowledge) {
      Map<String, String> map = convert(knowledge);

      StringBuilder result = new StringBuilder();
      char[] chs = s.toCharArray();
      boolean findLeft = false;
      boolean findRight = false;
      StringBuilder key = new StringBuilder();
      for (int i = 0; i < chs.length; i++) {
        char c = chs[i];

        if (c == '(') {
          findLeft = true;
          findLeft = false;
        }
        else if (c == ')') {
          findRight = true;
          result.append(map.getOrDefault(key.toString(), "?"));
          key.setLength(0);
          findLeft = false;
        }
        else if (findLeft && !findRight) {
          key.append(c);
        }
        else {
          result.append(c);
        }

      }
      return result.toString();

    }

    private static Map<String, String> convert(List<List<String>> input) {
      Map<String, String> res = new HashMap<>();
      for (List<String> l : input) {
        res.put(l.get(0), l.get(1));
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
