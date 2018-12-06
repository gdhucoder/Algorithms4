package Ch_4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/6.
 */

public class _SymbolGraph{

  private ST<String, Integer> st; // string -> index
  private  String[] keys; // index -> string
  private _AdjListGraph G;

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

    G = new _AdjListGraph(st.size());
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

  public _AdjListGraph G(){
    return G;
  }



  public static void main(String[] args) {
    // java Ch_4_1._SymbolGraph E:\gitspace\x1c\Alg4\algs4\src\main\algs4-data\routes.txt " "
    // java Ch_4_1._SymbolGraph E:\gitspace\x1c\Alg4\algs4\src\main\algs4-data\movies.txt "/"
    String filename = args[0];
    String delim = args[1];
    _SymbolGraph sg = new _SymbolGraph(filename, delim);
    _AdjListGraph G = sg.G();

    while (StdIn.hasNextLine()){
      String source = StdIn.readLine();
      for(int w : G.adj(sg.index(source))){
        StdOut.println(" "+sg.name(w));
      }
    }
  }

}
