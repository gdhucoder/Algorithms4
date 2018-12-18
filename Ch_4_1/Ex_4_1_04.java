package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/16.
 */

public class Ex_4_1_04 {

  public static class _AdjListGraph extends _Graph {

    private int V; // 顶点数目
    private int E; //边的数目
    private Bag<Integer>[] adj; // 邻接表

    public _AdjListGraph(int V) {
      this.V = V;
      this.E = 0;
      adj = (Bag<Integer>[]) new Bag[V]; // 创建邻接表
      for (int v = 0; v < V; v++) {
        adj[v] = new Bag<Integer>();
      }
    }

    public _AdjListGraph(In in) {
      this(in.readInt()); // 读取V并将图初始化
      int E = in.readInt(); // 读取E
      for (int i = 0; i < E; i++) {
        int v = in.readInt(); // 读取一个顶点
        int w = in.readInt(); // 读取另一个顶点
        addEdge(v, w); // 增加一条连接它们的边
      }
    }

    public _AdjListGraph(Ex_4_1_03._AdjListGraph G) {
      this(G.V());
      this.E = G.E();
      for (int v = 0; v < V; v++) {

        // 使用stack 按顺序将 邻接表中的数据入栈
        Stack<Integer> reverse = new Stack<>();
        for (int w : G.adj(v)) {
          reverse.push(w);
        }
        // 出栈，这样保证了边的顺序
        for (int w : reverse) {
          adj[v].add(w);
        }
      }
    }

    @Override
    public int V() {
      return V;
    }

    @Override
    public int E() {
      return E;
    }

    @Override
    public void addEdge(int v, int w) {
      adj[v].add(w);
      adj[w].add(v);
      E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
      return adj[v];
    }

    /**
     * 参考小黑：可以有些优化 判断Bag的size，由于是无向图 v-w与w-v等价 在较小的bag中搜索判断
     */
    public boolean hasEdge(int v, int w) {
      if ((v <= 0 || v >= this.V)
          || (w <= 0 || w >= this.V)) {
        throw new IllegalArgumentException("v should 0~" + (this.V - 1));
      }
      int ver = v;
      int edge = w;
      if (adj[v].size() > adj[w].size()) {
        ver = w;
        edge = v;
        StdOut.println("searching in smaller bag.");
      }

      for (int e : this.adj(ver)) {
        if (edge == e)
          return true;
      }
      return false;
    }

    @Override
    public String toString() {
      String s = V + " vertices, " + E + " edges.\n";
      for (int v = 0; v < V; v++) {
        s += v + ": ";
        for (int w : this.adj(v)) {
          s += w + " ";
        }
        s += "\n";
      }
      return s;
    }
  }

  public static void main(String[] args) {
    _AdjListGraph g = new _AdjListGraph(new In("tinyGex2.txt"));
    StdOut.println(g);
    boolean hasEdge = g.hasEdge(4, 1);
    StdOut.println("hasEdge: " + hasEdge);

    hasEdge = g.hasEdge(1, 4);
    StdOut.println("hasEdge: " + hasEdge);

//    hasEdge = g.hasEdge(4, 12);
//    StdOut.println("hasEdge: " + hasEdge);
  }
}
