//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

public class _0076_MinimumWindowSubstring {

  public static void main(String[] args) {
    Solution solution = new _0076_MinimumWindowSubstring().new Solution();
    String s = "aa";
    String t = "aa";
    System.out.println(solution.minWindow(s, t));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String minWindow(String s, String t) {
      int[] match = new int[256];
      int[] window = new int[256];
      int sz = 0;
      for (char c : t.toCharArray()) {
        match[c]++;
      }
      for (int n : match) {
        if (n > 0) sz++;
      }
      int left = 0, right = 0;
      int valid = 0, len = Integer.MAX_VALUE;
      int start = 0;
      while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        if (match[c] > 0) {
          window[c]++;
          if (window[c] == match[c]) {
            valid++;
          }
        }
        while (valid == sz) {
          if (right - left < len) {
            start = left;
            len = right - left;
          }
          char d = s.charAt(left);
          left++;
          if (match[d] > 0) {
            if (window[d] == match[d]) {
              valid--;
            }
            window[d]--;
          }
        }
      }
      return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}