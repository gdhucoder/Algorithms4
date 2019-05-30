package Ch_2_4;

import Ch_2_4.Ex_2_4_33.IndexMinPQ;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/5/30.
 */

public class _Multiway {

  public static void merge(In[] streams) {
    int N = streams.length;
    IndexMinPQ<String> pq = new IndexMinPQ<>(N);
    for (int i = 0; i < N; i++) {
      if (!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }
    while (!pq.isEmpty()){
      StdOut.println(pq.min());
      int i = pq.delMin();
      if(!streams[i].isEmpty()){
        pq.insert(i, streams[i].readString());
      }
    }
  }
}
