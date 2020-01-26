//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _0212_WordSearchIi_bestsolution_trie {

  public static void main(String[] args) {
    Solution solution = new _0212_WordSearchIi_bestsolution_trie().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> findWords(char[][] board, String[] words) {
      List<String> result = new ArrayList<>();
      TrieNode root = buildTree(words);
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          dfs(board, i, j, root, result);
        }
      }
      return result;
    }

    private TrieNode buildTree(String[] words) {
      TrieNode root = new TrieNode();
      for (String word : words) {
        TrieNode p = root;
        for (char ch : word.toCharArray()) {
          int i = ch - 'a';
          if (p.next[i] == null) {
            p.next[i] = new TrieNode();
          }
          p = p.next[i];
        }
        p.word = word;
      }
      return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
      // terminator
      char ch = board[i][j];
      if (ch == '#' || p.next[ch] == null)
        return;

      // process
      p = p.next[ch - 'a'];
      if (p.word != null) {
        result.add(p.word);
        p.word = null;
      }
      board[i][j] = '#';
      // drill down
      if (i > 0)
        dfs(board, i - 1, j, p, result);
      if (j > 0)
        dfs(board, i, j - 1, p, result);
      if (i < board.length - 1)
        dfs(board, i + 1, j, p, result);
      if (j < board[0].length - 1)
        dfs(board, i, j + 1, p, result);
      // clear status
      board[i][j] = ch;
    }

    class TrieNode {

      TrieNode[] next = new TrieNode[26];
      String word;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}