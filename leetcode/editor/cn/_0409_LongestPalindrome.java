//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 206 👎 0


package leetcode.editor.cn;

public class _0409_LongestPalindrome {

  public static void main(String[] args) {
    Solution solution = new _0409_LongestPalindrome().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int longestPalindrome(String s) {
      char[] chs = s.toCharArray();
      int[] cnt = new int[256];
      for (char ch : chs) {
        cnt[ch]++;
      }
      int res = 0;
      for (int n : cnt) {
        res += n / 2 * 2;
        if (n % 2 == 1 && res % 2 == 0) {
          res += 1;
        }
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}