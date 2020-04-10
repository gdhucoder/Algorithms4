//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _0438_FindAllAnagramsInAString_v1 {

  public static void main(String[] args) {
    Solution solution = new _0438_FindAllAnagramsInAString_v1().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)

  class Solution {

    private Map<Character, Integer> word = new HashMap<>();

    public List<Integer> findAnagrams(String s, String p) {
      char[] chs = p.toCharArray();
      int len = p.length();
      for (char c : chs) {
        word.put(c, word.getOrDefault(c, 0) + 1);
      }
      List<Integer> res = new ArrayList<>();
      char[] chars = s.toCharArray();
      for (int i = 0; i <= chars.length - len; i++) {
        if (isAnagram(chars, i, i + len)) {
          res.add(i);
        }
      }
      return res;
    }

    private boolean isAnagram(char[] chs, int start, int end) {
      Map<Character, Integer> temp = new HashMap<>();
      for (int i = start; i < end; i++) {
        char c = chs[i];
        temp.put(c, temp.getOrDefault(c, 0) + 1);
      }

      for (Entry<Character, Integer> e : temp.entrySet()) {
        if (word.get(e.getKey()) == null || !word.get(e.getKey()).equals(e.getValue()))
          return false;
      }
      return true;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}