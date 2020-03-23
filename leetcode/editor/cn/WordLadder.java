//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class WordLadder {

  public static void main(String[] args) {
    Solution solution = new WordLadder().new Solution();
    String[] strings = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    String beg = "hit";
    String end = "cog";
    ;
    solution.ladderLength(beg, end, Arrays.asList(strings));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      helper(0, beginWord, endWord, wordList);
      return 0;
    }

    private void helper(int level, String curWord, String endWord, List<String> wordList) {
      if (curWord.equals(endWord)) {
        System.out.println(curWord);
        return;
      }
      if (level == wordList.size()) {
        return;
      }
      System.out.println(curWord);

      for (int i = 0; i < wordList.size(); i++) {
        char[] chars = curWord.toCharArray();
        char tempChar = chars[level];
        chars[level] = wordList.get(i).charAt(level);
        String temp = String.valueOf(chars);
        System.out.println(temp);
        if (temp.equals(wordList.get(i))) {
          helper(level + 1, temp, endWord, wordList);
        }
        chars[level] = tempChar;
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}