package Ch_4_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/3/20.
 */
public class _SymbolGraphClient {

  public static void main(String[] args) {
    String filename = "algdata/movies.txt";
    String delim = "/";
    _SymbolGraph sg = new _SymbolGraph(filename, delim);
    _AdjListGraph graph = sg.graph();
    while (StdIn.hasNextLine()) {
      String source = StdIn.readLine();
      if (sg.contains(source)) {
        int s = sg.index(source);
        for (int v : graph.adj(s)) {
          StdOut.println(" " + sg.name(v));
        }
      } else {
        StdOut.println("input not contain " + source);
      }

    }
  }
}
