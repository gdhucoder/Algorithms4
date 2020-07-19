package ALeetCode.comp.p198;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
      Graph g = new Graph(edges, n);
      int[] res = new int[n];
      boolean[] marked = new boolean[n];
      char[] chs = labels.toCharArray();
      return null;
    }

    private void bfs(Graph G, int s, boolean[] marked, char[] chs, int[] res) {
      Queue<Integer> queue = new LinkedList<>();
      queue.add(s);
      marked[s] = true;
      while (!queue.isEmpty()) {
        int v = queue.poll();
        for (int w : G.adj[v]) {
          if (!marked[w]) {
            marked[w] = true;
            queue.add(w);
          }
        }
      }
    }

    private class Graph {

      List<Integer>[] adj;

      Graph(int[][] edges, int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
          adj[i] = new ArrayList<Integer>();
        }
        for (int[] e : edges) {
          adj[e[0]].add(e[1]);
        }
      }

    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
