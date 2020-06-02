//给你一个二进制字符串 s 和一个整数 k 。 
//
// 如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 True ，否则请返回 False 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "00110110", k = 2
//输出：true
//解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
// 
//
// 示例 2： 
//
// 输入：s = "00110", k = 2
//输出：true
// 
//
// 示例 3： 
//
// 输入：s = "0110", k = 1
//输出：true
//解释：长度为 1 的二进制串包括 "0" 和 "1"，显然它们都是 s 的子串。
// 
//
// 示例 4： 
//
// 输入：s = "0110", k = 2
//输出：false
//解释：长度为 2 的二进制串 "00" 没有出现在 s 中。
// 
//
// 示例 5： 
//
// 输入：s = "0000000001011100", k = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10^5 
// s 中只含 0 和 1 。 
// 1 <= k <= 20 
// 
// Related Topics 位运算 字符串


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK {

  public static void main(String[] args) {
    Solution solution = new _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK().new Solution();
    //    "00110"
    //    2
    String s = "0110";
    int k = 1;
    boolean res = solution.hasAllCodes(s, k);
    System.out.println(res);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean hasAllCodes1(String s, int k) {
      Map<String, Integer> map = new HashMap<>();
      int len = s.length();
      for (int i = 0; i <= len - k; i++) {
        String sub = s.substring(i, i + k);
        System.out.println(sub);
        map.put(sub, map.getOrDefault(sub, 0) + 1);
      }
      return map.size() == (int) Math.pow(2, k);
    }

    public boolean hasAllCodes2(String s, int k) {
      Set<String> seen = new HashSet<>();
      StringBuilder sb = new StringBuilder(s);
      int len = s.length();
      for (int i = 0; i <= len - k; i++) {
        String sub = sb.substring(i, i + k);
        seen.add(sub);
      }
      return seen.size() == 1 << k;
    }

    /**
     * bit manipulate
     *
     * @param s
     * @param k
     * @return
     */
    public boolean hasAllCodes(String s, int k) {
      if (s.length() < k) return false;
      boolean[] strings = new boolean[1 << k];
      int bit = 0;
      for (int i = 0; i < k; i++) {
        bit <<= 1;
        bit ^= (s.charAt(i) - '0');
      }
      strings[bit] = true;
      for (int i = k; i < s.length(); i++) {
        bit = bit << 1;
        bit = bit & ~(1 << k);
        bit ^= (s.charAt(i) - '0');
        strings[bit] = true;
      }
      for (boolean correct : strings)
        if (!correct) return false;
      return true;
    }
    // 0 0, 0 1, 1 0, 1 1
  }
  //leetcode submit region end(Prohibit modification and deletion)

}