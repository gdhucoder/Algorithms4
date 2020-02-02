package ALeetCode.comp.p170;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public List<String> printVertically(String s) {
      List<String> res = new ArrayList<>();
      String[] words = s.split(" ");
      int listMaxSize = -1;
      for (int i = 0; i < words.length; i++) {
        listMaxSize = Math.max(listMaxSize, words[i].length());
      }
      for (int i = 0; i < listMaxSize; i++) {
        res.add("");
      }

      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        for (int j = 0; j < word.length(); j++) {
          res.set(j, res.get(j) + word.charAt(j));
        }
        for (int j = word.length(); j < listMaxSize; j++) {
          res.set(j, res.get(j) + " ");
        }
      }
      for (int i = 0; i < res.size(); i++) {
        res.set(i, trimString(res.get(i)));
      }

      return res;
    }

    private String trimString(String last) {
      if (last.lastIndexOf(' ') != -1) {
        int limit = last.length() - 1;

        while (limit > 0) {
          if (last.charAt(limit) == ' ') {
            limit--;
          } else {
            break;
          }
        }
        if (limit >= 0) {
          last = last.substring(0, limit + 1);

        }
      }
      return last;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.printVertically("TO BE OR NOT TO BE"));
    System.out.println("123  ".indexOf(" "));
  }
}
