//给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最
//少需要多少秒，可以收集到所有苹果，并回到节点 0 。 
//
// 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数
//组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,fa
//lse,true,false,true,true,false]
//输出：8 
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,fa
//lse,true,false,false,true,false]
//输出：6
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 3： 
//
// 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,fa
//lse,false,false,false,false,false]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// edges.length == n-1 
// edges[i].length == 2 
// 0 <= fromi, toi <= n-1 
// fromi < toi 
// hasApple.length == n 
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1443_MinimumTimeToCollectAllApplesInATree {

  public static void main(String[] args) {
    Solution solution = new _1443_MinimumTimeToCollectAllApplesInATree().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private Boolean[] hasApp;
    private int[][] edges;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
      Arrays.sort(edges, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
          Arrays.sort(a);
          Arrays.sort(b);
          return a[0] - b[0];
        }
      });
      hasApp = hasApple.toArray(new Boolean[0]);
      this.edges = edges;
      Node head = buildTree(n, edges);
      return helper(head);
    }

    public int minTime2(int n, int[][] edges, Boolean[] hasApp) {
      Arrays.sort(edges, (a, b) -> (a[0] - b[0]));
      this.hasApp = hasApp;
      this.edges = edges;
      Node head = buildTree(n, edges);
      return helper(head);
    }


    private int helper(Node node) {
      if (node == null) return 0;
      //      System.out.println(node.val);

      List<Node> children = node.children;
      int res = 0;
      for (int i = 0; i < children.size(); i++) {
        res += helper(children.get(i));
      }

      if (res > 0) return res + (node.val == 0 ? 0 : 2);
      else if (hasApp[node.val]) {
        return 2;
      }
      else return 0;

    }

    private Node buildTree(int n, int[][] edges) {
      List<Node> tree = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        tree.add(new Node(i));
      }
      for (int i = 0; i < edges.length; i++) {
        tree.get(edges[i][0]).children.add(tree.get(edges[i][1]));
      }
      return tree.get(0);
    }


    class Node {

      int val;
      List<Node> children;

      Node(int val) {
        this.val = val;
        children = new ArrayList<>();
      }
    }


  }
  //leetcode submit region end(Prohibit modification and deletion)

}