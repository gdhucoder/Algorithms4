//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 280 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

public class _0767_ReorganizeString {

  public static void main(String[] args) {
    Solution solution = new _0767_ReorganizeString().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String reorganizeString(String s) {
      if (s.length() < 2) return s;
      int[] counts = new int[26];
      char[] chs = s.toCharArray();
      for (char c : chs) {
        counts[c - 'a']++;
      }
      for (int cnt : counts) {
        if (cnt > ((s.length() + 1) / 2)) return "";
      }
      PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> counts[b] - counts[a]);
      for (int i = 0; i < 26; i++) {
        if (counts[i] > 0) {
          queue.offer((char) (i + 'a'));
        }
      }
      StringBuilder sb = new StringBuilder();
      while (queue.size() > 1) {
        char letter1 = queue.poll();
        char letter2 = queue.poll();
        sb.append(letter1).append(letter2);
        int idx1 = letter1 - 'a', idx2 = letter2 - 'a';
        counts[idx1]--;
        counts[idx2]--;
        if (counts[idx1] > 0) queue.offer(letter1);
        if (counts[idx2] > 0) queue.offer(letter2);
      }
      if (queue.size() > 0) sb.append(queue.poll());
      return sb.toString();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}