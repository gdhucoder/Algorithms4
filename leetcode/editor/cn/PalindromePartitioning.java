//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {

  public static void main(String[] args) {
    Solution solution = new PalindromePartitioning().new Solution();
    solution.partition("aab");
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private Map<String, Boolean> map = new HashMap<>();

    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      char[] chs = s.toCharArray();
      helper(0, chs, new LinkedList<>(), res);

      return res;
    }

    private void helper(int pos, char[] chars, LinkedList<String> path, List<List<String>> res) {
      if (pos == chars.length) {
        System.out.println(path);
        res.add(new ArrayList<>(path));
        return;
      }
      if (pos > chars.length) {
        System.out.println(path);
        return;
      }
      for (int i = pos; i < chars.length; i++) {
        String sub = String.valueOf(chars, pos, i - pos + 1);
        if (isValid(sub)) {
          path.add(sub);
          helper(i + 1, chars, path, res);
          path.remove(path.size() - 1);
        }
      }
    }

    private boolean isValid(String sub) {
      if (map.containsKey(sub)) return map.get(sub);
      for (int i = 0; i < sub.length() / 2; i++) {
        if (sub.charAt(i) != sub.charAt(sub.length() - 1 - i)) {
          map.put(sub, false);
          return false;
        }
      }
      map.put(sub, true);
      return true;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}