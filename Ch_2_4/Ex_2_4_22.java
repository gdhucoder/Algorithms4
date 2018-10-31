package Ch_2_4;

import static tools.ArrayGenerator.ascIntArray;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/31.
 */

public class Ex_2_4_22 {

  public static void main(String[] args) {
    for(int i=0; i<3; i++){
      _MaxMQ<Integer> pq = new _MaxMQ<>();
      Integer[] a = ascIntArray(10*i);
      for(int j=0; j<a.length; j++){
        pq.insert(j);
      }

      while (!pq.isEmpty()){
        StdOut.printf("%5d\t", pq.delMax());
      }

      StdOut.println();
    }
  }
//    9	    8	    7	    6	    5	    4	    3	    2	    1	    0
//        19	   18	   17	   16	   15	   14	   13	   12	   11	   10	    9	    8	    7	    6	    5	    4	    3	    2	    1	    0


}
