package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/29.
 */

public class _DepthFirstSearch {

  private boolean[] marked;
  private int count;

  public _DepthFirstSearch(_Graph g, int s){
    marked = new boolean[g.V()];
    dfs(g,s);
  }

  private void dfs(_Graph g, int v){
    count++;
    marked[v] = true;
    for(int w : g.adj(v)){
      if(!marked[w]){
        dfs(g,w);
      }
    }
  }

  public boolean marked(int v){
    return marked[v];
  }

  public int count(){
    return count;
  }


//  java Ch_4_1._DepthFirstSearch E:\gitspace\x1c\Alg4\algs4\src\main\algs4-data\tinyG.txt 9
  public static void main(String[] args) {
//    _Graph g = new _Graph(new In(args[0]));
//    int s = Integer.parseInt(args[1]);
    _AdjListGraph g = new _AdjListGraph(new In("src/main/algs4-data/tinyG.txt"));
    int s = 0;
    _DepthFirstSearch dfs = new _DepthFirstSearch(g, s);
    for (int v = 0; v < g.V(); v++) {
      if(dfs.marked(v)){
        StdOut.print(v + " ");
      }
    }
    StdOut.println();
    if(dfs.count() != g.V()){
      StdOut.print("NOT");
    }
    StdOut.println("connected");

  }


}
