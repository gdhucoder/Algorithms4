//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

  public static void main(String[] args) {
    Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    solution.letterCombinations("23");
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
      List<String> res = new ArrayList<>();
      if (digits.length() == 0) return res;
      init();
      gen(0, "", digits, res);
      System.out.println(res);
      return res;
    }

    private void gen(int level, String cur, String digits, List<String> res) {
      if (digits.length() == cur.length()) {
        res.add(cur);
        return;
      }
      String letters = map.get(digits.charAt(level));
      for (int i = 0; i < letters.length(); i++) {
        gen(level + 1, cur + letters.charAt(i), digits, res);
      }
    }

    private void init() {
      map.put('2', "abc");
      map.put('3', "def");
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}