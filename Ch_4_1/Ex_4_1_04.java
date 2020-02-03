package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2/4/20.
 */
public class Ex_4_1_04 {

  public static void main(String[] args) {
    Ex_4_1_04 e = new Ex_4_1_04();
    _Graph g = new _Graph(new In("algdata/tinyGex2.txt"));
    PrintUtil.printSepLine("original");
    StdOut.println(g);
    int v = 2, w = 3;
    e._showHasEdge(g, v, w);
    v = 2;
    w = 9;
    e._showHasEdge(g, v, w);

//    2-3 true
//    2-9 false

  }

  private void _showHasEdge(_Graph g, int v, int w) {
    StdOut.printf("%d-%d %s\n", v, w, g.hasEdge(v, w));
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

    public boolean hasEdge(int v, int w) {
      isValidate(v);
      isValidate(w);
      for (int e : adj[v]) {
        if (e == w) {
          return true;
        }
      }
      return false;
    }


    private void isValidate(int v) {
      if (v < 0 || v >= V) {
        throw new IllegalArgumentException("v must between 0 and V");
      }
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
