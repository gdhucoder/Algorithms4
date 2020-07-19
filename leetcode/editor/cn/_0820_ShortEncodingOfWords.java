//给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。 
//
// 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0,
// 2, 5]。 
//
// 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。 
//
// 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？ 
//
// 
//
// 示例： 
//
// 输入: words = ["time", "me", "bell"]
//输出: 10
//说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// 每个单词都是小写字母 。 
// 
// 👍 183 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0820_ShortEncodingOfWords {

  public static void main(String[] args) {
    Solution solution = new _0820_ShortEncodingOfWords().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minimumLengthEncoding(String[] words) {
      Set<String> s = new HashSet<>(Arrays.asList(words));
      for (String w : words)
        for (int i = 1; i < w.length(); ++i)
          s.remove(w.substring(i));
      int res = 0;
      for (String w : s) res += w.length() + 1;
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}