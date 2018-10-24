package edu.princeton.cs.myalg.u2.u2_2;

/**
 * Created by HuGuodong on 2018/8/8.
 */

public class Ex_2_2_2 {

//  merge(a, 0, 0, 1) A E S Y Q U E S T I O N
//  merge(a, 0, 1, 2) A E S Y Q U E S T I O N
//  merge(a, 3, 3, 4) A E S Q Y U E S T I O N
//  merge(a, 3, 4, 5) A E S Q U Y E S T I O N
//  merge(a, 0, 2, 5) A E Q S U Y E S T I O N
//  merge(a, 6, 6, 7) A E Q S U Y E S T I O N
//  merge(a, 6, 7, 8) A E Q S U Y E S T I O N
//  merge(a, 9, 9,10) A E Q S U Y E S T I O N
//  merge(a, 9,10,11) A E Q S U Y E S T I N O
//  merge(a, 6, 8,11) A E Q S U Y E I N O S T
//  merge(a, 0, 5,11) A E E I N O Q S S T U Y
  public static void main(String[] args) {
    String[] a = args;
    MergeSort.sort(a);
  }

}
