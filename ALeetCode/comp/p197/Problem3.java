package ALeetCode.comp.p197;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
      return 0;
    }

    private void bfs(G g, int s) {
      LinkedList<Integer> queue = new LinkedList<>();
      queue.addFirst(s);
      boolean[] marked = new boolean[g.V];
      marked[s] = true;
      double[] prob = new double[g.V];

      //      while (!queue.isEmpty()) {
      //        int v = queue.removeLast();
      //        for (Edge e : g.adjList[v]) {
      //          if (!marked[e.]) {
      //            marked[w] = true;
      //            prob[w] *= v;
      //            queue.addFirst(w);
      //          }
      //        }
      //      }
    }
  }


  private class G {

    int V;
    int E;
    List<Edge>[] adjList;

    G(int V, int[][] edges, double[] weights) {
      this.V = V;
      adjList = new List[V];
      for (int i = 0; i < V; i++) {
        adjList[i] = new ArrayList<>();
      }
      for (int i = 0; i < edges.length; i++) {
        Edge e = new Edge(edges[i][0], edges[i][1], weights[i]);
        adjList[edges[i][0]].add(e);
        adjList[edges[i][1]].add(e);
        E++;
      }
    }
  }

  private class Edge {

    int v;
    int w;
    double weight;

    Edge(int v, int w, double weight) {
      this.v = v;
      this.w = w;
      this.weight = weight;
    }
  }


  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
