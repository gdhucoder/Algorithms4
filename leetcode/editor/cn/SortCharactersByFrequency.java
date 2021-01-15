//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表 
// 👍 201 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

  public static void main(String[] args) {
    Solution solution = new SortCharactersByFrequency().new Solution();
    System.out.println(solution.frequencySort("tree"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public String frequencySort(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (Character c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      PriorityQueue<Character> que = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
      for (Character c : map.keySet()) {
        que.offer(c);
      }
      StringBuilder sb = new StringBuilder();
      while (!que.isEmpty()) {
        char c = que.poll();
        int times = map.get(c);
        sb.append(String.valueOf(c).repeat(times));
      }
      return sb.toString();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}