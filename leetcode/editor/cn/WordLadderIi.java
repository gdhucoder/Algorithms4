//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderIi {

  /**
   * The basic idea is:
   * <p>
   * 1). Use BFS to find the shortest distance between start and end, tracing the distance of
   * crossing nodes from start node to end node, and store node's next level neighbors to HashMap;
   * <p>
   * 2). Use DFS to output paths with the same distance as the shortest distance from distance
   * HashMap: compare if the distance of the next level node equals the distance of the current node
   * + 1.
   *
   * @param args
   */
  public static void main(String[] args) {
    Solution solution = new WordLadderIi().new Solution();
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
      HashSet<String> dict = new HashSet<String>(wordList);
      List<List<String>> res = new ArrayList<List<String>>();
      HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
      HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
      ArrayList<String> solution = new ArrayList<String>();

      dict.add(start);
      bfs(start, end, dict, nodeNeighbors, distance);
      dfs(start, end, nodeNeighbors, distance, solution, res);
      return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict,
        HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
      for (String str : dict)
        nodeNeighbors.put(str, new ArrayList<String>());

      Queue<String> queue = new LinkedList<String>();
      queue.offer(start);
      distance.put(start, 0);

      while (!queue.isEmpty()) {
        int count = queue.size();
        boolean foundEnd = false;
        for (int i = 0; i < count; i++) {
          String cur = queue.poll();
          int curDistance = distance.get(cur);
          ArrayList<String> neighbors = getNeighbors(cur, dict);

          for (String neighbor : neighbors) {
            nodeNeighbors.get(cur).add(neighbor);
            if (!distance.containsKey(neighbor)) {// Check if visited
              distance.put(neighbor, curDistance + 1);
              if (end.equals(neighbor))// Found the shortest path
                foundEnd = true;
              else
                queue.offer(neighbor);
            }
          }
        }

        if (foundEnd)
          break;
      }
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
      ArrayList<String> res = new ArrayList<String>();
      char chs[] = node.toCharArray();

      for (char ch = 'a'; ch <= 'z'; ch++) {
        for (int i = 0; i < chs.length; i++) {
          if (chs[i] == ch)
            continue;
          char old_ch = chs[i];
          chs[i] = ch;
          if (dict.contains(String.valueOf(chs))) {
            res.add(String.valueOf(chs));
          }
          chs[i] = old_ch;
        }

      }
      return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, HashMap<String, ArrayList<String>> nodeNeighbors,
        HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
      solution.add(cur);
      if (end.equals(cur)) {
        res.add(new ArrayList<String>(solution));
      } else {
        for (String next : nodeNeighbors.get(cur)) {
          if (distance.get(next) == distance.get(cur) + 1) {
            dfs(next, end, nodeNeighbors, distance, solution, res);
          }
        }
      }
      solution.remove(solution.size() - 1);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}