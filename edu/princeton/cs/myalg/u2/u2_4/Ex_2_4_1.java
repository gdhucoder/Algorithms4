package edu.princeton.cs.myalg.u2.u2_4;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/15.
 */

public class Ex_2_4_1 {

  public static void main(String[] args) {
    String str = "P R I O * R * * I * T * Y * * * Q U E * * * U * E";
    MyMaxPQ<String> pq = new MyMaxPQ<>(str.length());
    String[] arr = str.split(" ");
    for(int i=0; i<arr.length; i++){
      String item = arr[i];
      if(item.equals("*")){
        StdOut.print(pq.delMax() + " ");
      }else{
        pq.insert(item);
      }
    }

    if(pq.size()>0){
      StdOut.print("(");
      String left = "";
      while (!pq.isEmpty()){
        left += pq.delMax()+" ";
      }
      StdOut.println(left +"left on pq)");
    }
  }

}
