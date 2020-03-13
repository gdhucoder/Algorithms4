package Ch_4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 3/13/20.
 */
public class Ex_4_2_03 {

  public static void main(String[] args) {
    String filePath = "algdata/tinyDG.txt";
    Digraph G = new Digraph(new In(filePath));

    Digraph copy = new Digraph(G);
    copy.addEdge(12, 1);

    StdOut.println(G);
    PrintUtil.printSepLine();
    StdOut.println(copy);
    //    13 vertices, 22 edges
    //    0->5->1
    //    1
    //    2->0->3
    //    3->5->2
    //    4->3->2
    //    5->4
    //    6->9->4->8->0
    //    7->6->9
    //    8->6
    //    9->11->10
    //    10->12
    //    11->4->12
    //    12->9
    //
    //        ------------------------------------------------------
    //    13 vertices, 23 edges
    //    0->5->1
    //    1
    //    2->0->3
    //    3->5->2
    //    4->3->2
    //    5->4
    //    6->9->4->8->0
    //    7->6->9
    //    8->6
    //    9->11->10
    //    10->12
    //    11->4->12
    //    12->1->9
  }

  public static class Digraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
      this.V = V;
      this.E = 0;
      adj = (Bag<Integer>[]) new Bag[V];
      for (int v = 0; v < V; v++)
        adj[v] = new Bag<>();
    }

    public Digraph(In in) {
      this(in.readInt());
      int E = in.readInt();
      for (int i = 0; i < E; i++) {
        int v = in.readInt();
        int w = in.readInt();
        addEdge(v, w);
      }
    }

    public void addEdge(int v, int w) {
      adj[v].add(w);
      E++;
    }

    public Iterable<Integer> adj(int v) {
      return adj[v];
    }

    public Digraph reverse() {
      Digraph reverse = new Digraph(this.V);
      for (int v = 0; v < V; v++) {
        for (int w : adj(v)) {
          reverse.addEdge(w, v);
        }
      }
      return reverse;
    }

    public Digraph(Digraph copy) {
      this(copy.V);
      Stack<Integer> stack = new Stack<>();
      for (int v = 0; v < V; v++) {
        for (int w : copy.adj(v)) {
          stack.push(w);
        }
        while (!stack.isEmpty()) {
          addEdge(v, stack.pop());
        }
      }
    }

    public boolean hasEdge(int v, int w) {

      for (Integer vv : adj(v)) {
        if (vv == w) return true;
      }

      return false;
    }

    @Override
    public String toString() {
      String s = V + " vertices, " + E + " edges\n";
      for (int v = 0; v < V; v++) {
        s += v + "->";
        for (Integer w : adj[v])
          s += w + "->";
        s = s.substring(0, s.length() - 2);
        s += "\n";
      }
      return s;
    }


  }
}
