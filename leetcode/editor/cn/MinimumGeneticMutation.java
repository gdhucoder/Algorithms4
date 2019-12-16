//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
//

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

  public static void main(String[] args) {
    Solution solution = new MinimumGeneticMutation().new Solution();
//    start: "AAAAACCC"
//    end:   "AACCCCCC"
//    bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

    String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
    int ret = solution.minMutation("AAAAACCC", "AACCCCCC", bank);
    System.out.println(ret);


  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int minMutation(String start, String end, String[] bank) {
      if (start.equals(end)) {
        return 0;
      }

      Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
//      if (!bankSet.contains(end)) {
//        return -1;
//      }

      char[] gene = new char[]{'A', 'G', 'C', 'T'};

      Queue<String> queue = new LinkedList<>();
      Set<String> visited = new HashSet<>();

      queue.offer(start);
      visited.add(start);
      int level = 0;
      while (queue.size() != 0) {
        int size = queue.size();
        while (size-- > 0) {
          String curString = queue.poll();
          if (curString.equals(end)) {
            return level;
          }
          char[] curArr = curString.toCharArray();
          for (int i = 0; i < curArr.length; i++) {
            char old = curArr[i];
            for (char c : gene) {
              curArr[i] = c;
              String next = new String(curArr);
              if (!visited.contains(next) && bankSet.contains(next)) {
                visited.add(next);
                queue.offer(next);
              }
            }
            curArr[i] = old;
          }
        }
        level++;
      }
      return -1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}