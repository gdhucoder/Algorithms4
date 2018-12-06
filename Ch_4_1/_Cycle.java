package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/3.
 */

public class _Cycle {

  private boolean[] marked;
  private boolean hasCycle;

  public _Cycle(_Graph G){
    marked = new boolean[G.V()];
    for (int s = 0; s < G.V(); s++) {
      if(!marked[s]){
        dfs(G, s, s);
      }
    }
  }

  private void dfs(_Graph G, int v, int u){
    marked[v] = true;
    for(int w : G.adj(v)){
      if(!marked[w]){
        dfs(G, w, v);
      }else if(w!=u){ // 到达尽头，返回
          hasCycle = true;
        }
      }
    }


  public boolean hasCycle(){
    return hasCycle;
  }

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("src/main/algs4-data/tinyG.txt"));
    _Cycle cycle = new _Cycle(G);

    boolean hasCycle = cycle.hasCycle();

    StdOut.println("hasCycle? " + hasCycle);


  }

}




