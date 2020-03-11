//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0093_RestoreIpAddresses {

  public static void main(String[] args) {
    Solution solution = new _0093_RestoreIpAddresses().new Solution();
    String ip = "25525511135";
    Deque<String> que = new ArrayDeque<>(4);
    solution.restoreIpAddresses(ip);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> restoreIpAddresses(String s) {
      List<String> res = new ArrayList<>();
      dfs(0, 0, new ArrayDeque<>(4), s, res);
      return null;
    }

    private void dfs(int begin, int splitTimes, Deque<String> que, String s, List<String> res) {
      if (begin == s.length() && splitTimes == 4) {
        System.out.println(que);
        String ip = String.join(".", que);
        res.add(ip);
        return;
      }
      if (splitTimes > 4) return;
      for (int i = 0; i < 3; i++) {
        if (begin + i >= s.length()) continue;
        String sub = s.substring(begin, begin + i + 1);
        if (!isValid(sub)) continue;
        que.addLast(sub);
        dfs(begin + i + 1, splitTimes + 1, que, s, res);
        que.removeLast();
      }
    }

    private boolean isValid(String str) {
      if (str.length() > 1 && str.charAt(0) == '0') return false;
      if (Integer.valueOf(str) > 255) return false;
      return true;
    }

  }
  //leetcode submit region end(Prohibit modification and deletion)

}