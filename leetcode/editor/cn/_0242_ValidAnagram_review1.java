//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package leetcode.editor.cn;

import java.util.Arrays;

public class _0242_ValidAnagram_review1 {

  public static void main(String[] args) {
    Solution solution = new _0242_ValidAnagram_review1().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    // create an counter array to store alphabet frequency
    public boolean isAnagram_2(String s, String t) {
      if (s.length() != t.length()) return false;
      char[] arrS = s.toCharArray(), arrT = t.toCharArray();
      int[] counter = new int[26];
      for (int i = 0; i < arrS.length; i++) {
        counter[arrS[i] - 'a']++;
        counter[arrT[i] - 'a']--;
      }
      for (int cnt : counter)
        if (cnt != 0) return false;
      return true;
    }

    // s,t to char array, then sort array, compare each element
    public boolean isAnagram_1(String s, String t) {
      if (s.length() != t.length()) return false;
      char[] arrS = s.toCharArray(), arrT = t.toCharArray();
      Arrays.sort(arrS);
      Arrays.sort(arrT);
      return Arrays.equals(arrS, arrT);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}