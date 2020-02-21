//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049_GroupAnagrams {

  public static void main(String[] args) {
    Solution solution = new _0049_GroupAnagrams().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<String>> groupAnagrams(String[] a) {
      if (a.length == 0) return new ArrayList();
      Map<String, List<String>> ans = new HashMap<>();
      for (String s : a) {
        char[] ca = s.toCharArray();
        char[] arr = new char[26];
        for (char c : ca) arr[c - 'a']++;
        //        Arrays.sort(ca);
        String key = String.valueOf(arr);
        if (ans.get(key) == null) {
          ans.put(key, new ArrayList());
        }
        ans.get(key).add(s);
      }
      return new ArrayList<>(ans.values());
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}