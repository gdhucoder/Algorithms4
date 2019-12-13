package geekbang.ALGO.u31;

import edu.princeton.cs.algs4.In;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HuGuodong on 12/14/19.
 */

public class Graph { // 无向图

  private int v; // 顶点的个数
  private int e;
  private LinkedList<Integer> adj[]; // 邻接表

  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int s, int t) { // 无向图一条边存两次
    adj[s].add(t);
    adj[t].add(s);
  }

  public Graph(In in) {
    this(in.readInt());
    e = in.readInt();
    for (int i = 0; i < e; i++) {
      int s = in.readInt();
      int t = in.readInt();
      addEdge(s, t);
    }
  }


  public void bfs(int s, int t) {
    if (s == t)
      return;
    boolean[] visited = new boolean[v];
    visited[s] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    int[] prev = new int[v];
    for (int i = 0; i < v; ++i) {
      prev[i] = -1;
    }
    while (queue.size() != 0) {
      int w = queue.poll();
      for (int i = 0; i < adj[w].size(); ++i) {
        int q = adj[w].get(i);
        if (!visited[q]) {
          prev[q] = w;
          if (q == t) {
            print(prev, s, t);
            return;
          }
          visited[q] = true;
          queue.add(q);
        }
      }
    }
  }

  private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
    if (prev[t] != -1 && t != s) {
      print(prev, s, prev[t]);
    }
    System.out.print(t + " ");
  }


}