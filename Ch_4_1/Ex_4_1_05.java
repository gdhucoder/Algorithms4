package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/5/20.
 */
public class Ex_4_1_05 {

  public static void main(String[] args) {
    _Graph g = new _Graph(4);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    // java.lang.IllegalArgumentException: parallel edges for edge: 2-1
    // g.addEdge(2,1);
    // java.lang.IllegalArgumentException: self loop for vertex: 3
    // g.addEdge(3, 3);
    StdOut.println(g);
//    4 vertices, 2 edges
//    0:
//    1: 3 2
//    2: 1
//    3: 1
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

    /**
     * clone a graph
     *
     * @param src
     */
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
      // self loop
      checkSelfLoop(v, w);
      checkParallelEdges(v, w);
      adj[v].add(w);
      adj[w].add(v);
      E++;
    }

    private void checkSelfLoop(int v, int w) {
      if (v == w)
        throw new IllegalArgumentException("self loop for vertex: " + v);
    }

    private void checkParallelEdges(int v, int w) {
      for (int e : adj[v]) {
        if (e == w) {
          throw new IllegalArgumentException("parallel edges for edge: " + v + "-" + w);
        }
      }
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
