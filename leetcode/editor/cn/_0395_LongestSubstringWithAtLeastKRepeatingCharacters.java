//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 361 👎 0


package leetcode.editor.cn;

public class _0395_LongestSubstringWithAtLeastKRepeatingCharacters {

  public static void main(String[] args) {
    Solution solution = new _0395_LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int longestSubstring(String s, int k) {
      if (s == null || s.length() == 0) return 0;
      if (k < 2) return s.length();
      return helper(s, 0, s.length(), k);
    }

    public int helper(String s, int l, int r, int k) {
      if (l >= r) return 0;

      int[] freq = new int[26];
      for (int i = l; i < r; i++) freq[s.charAt(i) - 'a']++;

      boolean valid = true;
      for (int i = 0; i < 26 && valid; i++) if (freq[i] > 0 && freq[i] < k) valid = false;

      if (valid) return r - l;

      int best = 0, start = l;
      for (int i = l; i < r; i++) {
        if (freq[s.charAt(i) - 'a'] < k) {
          best = Math.max(best, helper(s, start, i, k));
          start = i + 1;
        }
      }
      best = Math.max(best, helper(s, start, r, k));
      return best;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}