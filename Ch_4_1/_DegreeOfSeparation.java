package Ch_4_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2/3/20.
 */
public class _DegreeOfSeparation {

  public static void main(String[] args) {
    // https://algs4.cs.princeton.edu/41graph/DegreesOfSeparation.java.html
    // java DegreesOfSeparation filename delimiter source
    // java DegreesOfSeparation movies.txt "/" "Animal House (1978)"
    String filename = "algdata/routes.txt";
    String delim = " ";
    String source = "JFK";

    _SymbolGraph sg = new _SymbolGraph(filename, delim);
    _AdjListGraph graph = sg.graph();

    if (!sg.contains(source)) {
      StdOut.println(source + " not in database");
      return;
    }

    int s = sg.index(source);

    _BreadthFirstSearch bfs = new _BreadthFirstSearch(graph, s);

    while (!StdIn.isEmpty()) {
      String sink = StdIn.readLine();
      if (sg.contains(sink)) {
        int t = sg.index(sink);
        if (bfs.hasPathTo(t)) {
          for (int v : bfs.pathTo(t)) {
            StdOut.println(" " + sg.name(v));
          }
        } else {
          StdOut.println("Not connected");
        }
      } else {
        StdOut.println("Not in database");
      }
    }

  }
}
