package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/4.
 */

public class _TwoColor {
  private boolean[] marked;
  private boolean[] color;
  private boolean isTwoColorable = true;

  public _TwoColor(_Graph G){
    marked = new boolean[G.V()];
    color = new boolean[G.V()];

    for (int s = 0; s < G.V(); s++) {
      if(!marked[s]){
        dfs(G, s);
      }
    }

  }


  private void dfs(_Graph G, int v){
    marked[v] = true;
    for(int w : G.adj(v)){
      if(!marked[w]){
        color[w] = !color[v];
      }else if(color[w] == color[v]){
        isTwoColorable = false;
      }
    }
  }

  public boolean isBipartite(){
    return isTwoColorable;
  }

  public static void main(String[] args) {
    _AdjListGraph G = new _AdjListGraph(new In("src/main/algs4-data/tinyG.txt"));
    _TwoColor color = new _TwoColor(G);

    boolean isBipartite = color.isBipartite();
    StdOut.println("isBipartite ? " + isBipartite);


  }


}
