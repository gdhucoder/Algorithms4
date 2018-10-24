package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/5/15.
 */

public class Ex_1_1_3 {

  public static void main(String[] args) {

//    args[0] = "1";
//    args[1] = "1";
////    args[2] = "1";
//    args[2] = "0";

    int a = StdIn.readInt();
    int b = StdIn.readInt();
    int c = StdIn.readInt();

    if(a == b
        && b == c){
      StdOut.println("Three Integers are equal!");
    }else {
      StdOut.println("Three Integers are not equal!");
    }
  }

}
