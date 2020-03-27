//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.List;

public class _0139_WordBreak {

  public static void main(String[] args) {
    Solution solution = new _0139_WordBreak().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
      int n = s.length();
      boolean[] dp = new boolean[n + 1];
      dp[0] = true;
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
          // 0,j-1; j,i 满足
          if (dp[j] && wordDict.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[n];
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}