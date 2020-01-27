package Ch_4_1;

import edu.princeton.cs.algs4.In;

/**
 * Created by HuGuodong on 1/28/20.
 */
public class __AdjListGraphClient {

  public static void main(String[] args) {
    __AdjListGraph g = new __AdjListGraph(new In("algdata/tinyG.txt"));
    System.out.println(g);
  }
}
