package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * Created by HuGuodong on 2018/12/6.
 */

public class _SymbolGraph{

  private ST<String, Integer> st; // string -> index
  private  String[] keys; // index -> string
  private _Graph G;

  public _SymbolGraph(String stream, String sp){
    st = new ST<>();
    In in = new In(stream);

    while (in.hasNextLine()){
      String[] a = in.readLine().split(sp);
      for (int i = 0; i < a.length; i++) {
        if(!st.contains(a[i])){
          st.put(a[i], st.size());
        }
      }
    }

    keys = new String[st.size()];
    for(String key : st.keys()){
      keys[st.get(key)] = key;
    }

    G = new _Graph(st.size());
    // second pass
    in = new In(stream);

    while (in.hasNextLine()){
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]); // first vertex
      for (int i = 1; i < a.length; i++) {
        G.addEdge(v, st.get(a[i]));
      }
    }

  }

  public boolean contains(String key){
    return st.contains(key);
  }

  public int index(String key){
    return st.get(key);
  }


  public String name(int v){
    return keys[v];
  }

  public _Graph G(){
    return G;
  }



  public static void main(String[] args) {

  }

}
