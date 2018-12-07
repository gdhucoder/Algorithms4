package Ch_4_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/7.
 */

public class _DegreeOfSeparation {

  // java Ch_4_1._DegreeOfSeparation E:\gitspace\x1c\Alg4\algs4\src\main\algs4-data\routes.txt " " JFK
  // java Ch_4_1._DegreeOfSeparation E:\gitspace\x1c\Alg4\algs4\src\main\algs4-data\movies.txt "/" "Bacon, Kevin"
  //  Kidman, Nicole
  //      Bacon, Kevin
  //      Woodsman, The (2004)
  //      Grier, David Alan
  //      Bewitched (2005)
  //      Kidman, Nicole

  public static void main(String[] args) {
    String filename = args[0];
    String delim = args[1];
    String source = args[2];
    _SymbolGraph sg = new _SymbolGraph(filename, delim);

    if (!sg.contains(source)) {
      StdOut.println(source + " not in database");
    }

    int s = sg.index(source);
    _BreadthFirstPaths bfs = new _BreadthFirstPaths(sg.G(), s);

    while (!StdIn.isEmpty()) {
      String sink = StdIn.readLine();
      if (sg.contains(sink)) {
        int t = sg.index(sink);
        if (bfs.hasPathTo(t)) {
          for (int v : bfs.pathTo(t)) {
            StdOut.println("    " + sg.name(v));
          }
        } else {
          StdOut.println("Not in database");
        }
      }
    }

  }
}
