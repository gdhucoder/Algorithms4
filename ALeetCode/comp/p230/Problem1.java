package ALeetCode.comp.p230;

import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
      int ret = 0;
      for (List<String> item : items) {
        if ((ruleKey.equals("type") && ruleValue.equals(item.get(0))) || (ruleKey.equals("color")
            && ruleValue.equals(item.get(1))) || (ruleKey.equals("name") && ruleValue
            .equals(item.get(2)))) {
          ret++;
        }
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
