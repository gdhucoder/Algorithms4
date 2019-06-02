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

  public static void main(String[] args) {
    int N = args.length;
    In[] streams = new In[N];
    for (int i = 0; i < N; i++) {
      streams[i] = new In(args[i]);
    }
    merge(streams);

//    E:\gitspace\x1c\Alg4\algs4>cd .\target\classes
//
//    E:\gitspace\x1c\Alg4\algs4\target\classes>java Ch_2_4._Multiway m1.txt m2.txt m3.txt



  }

}
