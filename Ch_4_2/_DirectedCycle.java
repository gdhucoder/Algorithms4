package Ch_4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/10.
 */

public class _DirectedCycle {

  private boolean[] marked; // marked[v] = has vertex v been marked?
  private int[] edgeTo; // edgeTo[v] = previous vertex on path to v
  private Stack<Integer> cycle; // vertices on a cycle(if one exists)

  // 跟踪未完成的递归栈
  private boolean[] onStack; // onStack[v] = is vertex on the stack?

  public _DirectedCycle(_Digraph G) {
    onStack = new boolean[G.V()];
    edgeTo = new int[G.V()];
    marked = new boolean[G.V()];
    for (int v = 0; v < G.V(); v++) {
      if (!marked[v] && cycle == null)
        dfs(G, v);
    }
  }

  public void dfs(_Digraph G, int v) {
    onStack[v] = true;
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (this.hasCycle()) {
        return;
      } else if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      } else if (onStack[w]) {
        cycle = new Stack<>();
        for (int x = v; x != w; x = edgeTo[x]) {
          cycle.push(x);
        }
        cycle.push(w);
        cycle.push(v);
      }
    }
    onStack[v] = false;
  }

  public boolean hasCycle(){
    return cycle!=null;
  }

  public Iterable<Integer> cycle(){
    return cycle;
  }

  public static void main(String[] args) {
//    _Digraph dg = new _Digraph(new In("src/main/algs4-data/tinyDG.txt"));
    _Digraph dg = new _Digraph(new In("tinyDAG.txt"));
    _DirectedCycle finder =new _DirectedCycle(dg);
    if(finder.hasCycle()){
      for(int i : finder.cycle()){
        StdOut.print(i + "\t");
      }
      StdOut.println();
    }else{
      StdOut.println("No directed cycle!");
    }
  }


}
