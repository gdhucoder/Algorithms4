package Ch_4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 2018/11/26.
 */

public class _AdjListGraph extends _Graph {

  private int V; // 顶点数目
  private int E; //边的数目
  private Bag<Integer>[] adj; // 邻接表

  public _AdjListGraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Bag<Integer>[]) new Bag[V]; // 创建邻接表
    for(int v=0; v<V; v++){
      adj[v] = new Bag<Integer>();
    }
  }

  public _AdjListGraph(In in) {
    this(in.readInt()); // 读取V并将图初始化
    int E = in.readInt(); // 读取E
    for (int i = 0; i < E; i++) {
      int v = in.readInt(); // 读取一个顶点
      int w = in.readInt(); // 读取另一个顶点
      addEdge(v,w); // 增加一条连接它们的边
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
}
