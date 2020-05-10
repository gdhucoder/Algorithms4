package ALeetCode.comp.p188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    private Boolean[] hasApp;
    private int[][] edges;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
      hasApp = hasApple.toArray(new Boolean[0]);
      this.edges = edges;
      Node head = buildTree(n, edges);
      return helper(head);
    }

    public int minTime2(int n, int[][] edges, Boolean[] hasApp) {
      Arrays.sort(edges, (a, b) -> (a[0] - b[0]));
      PrintUtil.show(edges);
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

  public static void main(String[] args) {
    int[][] edges = {{0, 1}, {1, 2}, {0, 3}};
    Boolean[] hasApple = {true, true, true, true};
    System.out.println();
    Solution s = new Solution();
    System.out.println(s.minTime2(4, edges, hasApple));
  }
}
