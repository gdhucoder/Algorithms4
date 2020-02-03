package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2/4/20.
 */
public class Ex_4_1_03 {

  public static void main(String[] args) {
    _Graph g = new _Graph(new In("algdata/tinyG.txt"));
    PrintUtil.printSepLine("original");
    StdOut.println(g);
    _Graph another = new _Graph(g);
    PrintUtil.printSepLine("copy");
    StdOut.println(another);
//    -----------------------original-------------------------------
//    13 vertices, 13 edges
//    0: 6 2 1 5
//    1: 0
//    2: 0
//    3: 5 4
//    4: 5 6 3
//    5: 3 4 0
//    6: 0 4
//    7: 8
//    8: 7
//    9: 11 10 12
//    10: 9
//    11: 9 12
//    12: 11 9
//
//    -----------------------copy-------------------------------
//    13 vertices, 13 edges
//    0: 6 2 1 5
//    1: 0
//    2: 0
//    3: 5 4
//    4: 5 6 3
//    5: 3 4 0
//    6: 0 4
//    7: 8
//    8: 7
//    9: 11 10 12
//    10: 9
//    11: 9 12
//    12: 11 9

  }

  static class _Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public _Graph(int V) {
      this.V = V;
      this.E = 0;
      adj = (Bag<Integer>[]) new Bag[V];
      for (int v = 0; v < V; v++) {
        adj[v] = new Bag<>();
      }
    }

    public _Graph(In in) {
      this(in.readInt());
      int E = in.readInt();

      for (int i = 0; i < E; i++) {
        int v = in.readInt();
        int w = in.readInt();
        addEdge(v, w);
      }

    }

    public _Graph(_Graph src) {
      this(src.V);

      Stack<Integer> stack = new Stack<>();

      for (int v = 0; v < V; v++) {
        for (int w : src.adj[v]) {
          stack.push(w);
        }
        while (!stack.isEmpty()) {
          adj[v].add(stack.pop());
        }
      }
      this.E = src.E;
    }

    public void addEdge(int v, int w) {
      adj[v].add(w);
      adj[w].add(v);
      E++;
    }

    public int V() {
      return V;
    }

    public int E() {
      return E;
    }

    @Override
    public String toString() {
      String result = String.format("%d vertices, %d edges\n", V, E);
      for (int v = 0; v < V; v++) {
        result += (v + ":");
        for (int w : adj[v]) {
          result += (" " + w);
        }
        result += "\n";
      }
      return result;
    }
  }
}
