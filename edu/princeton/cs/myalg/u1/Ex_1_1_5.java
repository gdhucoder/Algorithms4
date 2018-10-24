package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/5/15.
 */

public class Ex_1_1_5 {

  public static void main(String[] args) {
    double x = StdIn.readDouble();
    double y = StdIn.readDouble();

    if((x >0 && x < 1)
        && (y>0 && y<1)){
      StdOut.println(true);
    }else{
      StdOut.println(false);
    }

  }

}
