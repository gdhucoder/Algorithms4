package edu.princeton.cs.myalg.u1;

/**
 * Created by HuGuodong on 2018/5/17.
 */

public class Ex_1_1_14 {

  public static void main(String[] args) {

    System.out.println(lg(9));

  }

  public static int lg(int N){
    int result = 0;
    while (N>1){
      N/=2;
      result++;
    }
    return result;
  }
}
