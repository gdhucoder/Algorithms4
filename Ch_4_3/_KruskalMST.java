package Ch_4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Created by HuGuodong on 2018/12/23.
 */

public class _KruskalMST {

  private Queue<_Edge> mst;

  public _KruskalMST(_EdgeWeightedGraph G){
    mst = new Queue<_Edge>();
    MinPQ<_Edge> pq = new MinPQ<>();
    for(_Edge e:G.edges()){
      pq.insert(e);
    }

    UF uf = new UF(G.V());
    while (!pq.isEmpty() && mst.size()<G.V() -1){
      _Edge e = pq.delMin();
      int v = e.either(), w = e.other(v);
      if(uf.connected(v, w)){
        continue;
      }
      uf.union(v,w);
      mst.enqueue(e);
    }
  }

  public Iterable<_Edge> edges(){
    return mst;
  }



}
