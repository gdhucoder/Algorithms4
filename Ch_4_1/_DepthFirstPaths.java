package Ch_4_1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/29.
 */

public class _DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo; // edgeTo[v] = last edge on s-v path
  private final int s; // source
  public _DepthFirstPaths(_Graph g, int s){
    marked = new boolean[g.V()];
    edgeTo = new int[g.V()];
    dfs(g,s);
    this.s = s;
  }

  private void dfs(_Graph g, int v){
    marked[v] = true;
    for (int w : g.adj(v)){
      if(!marked[w]){
        edgeTo[w] = v;
        dfs(g,w);
      }
    }
  }

  public boolean hasPathTo(int v){
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v){
    if(!hasPathTo(v)){
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for(int x = v; x!=s; x = edgeTo[x]){
      path.push(x);
    }
    path.push(s);
    return path;
  }

  public static void main(String[] args) {
    _AdjListGraph g = new _AdjListGraph(new In("src/main/algs4-data/tinyCG.txt"));
    int s = 5;
    _DepthFirstPaths dfs = new _DepthFirstPaths(g, s);
    for (int v = 0; v < g.V(); v++) {
      StdOut.printf("%d to %d: ", s, v);
      if(dfs.hasPathTo(v)){
        for(int x : dfs.pathTo(v)){
          StdOut.print(x+" ");
        }
        StdOut.println();
      }else{
        StdOut.println("are not CONNECTED!");
      }
    }
  }

}
