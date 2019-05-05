package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/5/5.
 */

public class Ex_1_1_30 {

  private static int gcd(int p, int q) {
    if (p < 0 || q < 0) {
      throw new IllegalArgumentException("q or q must greater than zero.");
    }
    if (q == 0) {
      return p;
    }
    int r = p % q;
    return gcd(q, r);
  }

  public static boolean[][] genArray(int N){
    boolean[][] a = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(gcd(i,j)==1){
          a[i][j] = true;
        }
      }
    }
    return a;
  }

  public static void show(boolean[][] a){
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if(a[i][j]){
          StdOut.printf("T\t");
        }else{
          StdOut.printf("F\t");
        }
      }
      StdOut.println();
    }
  }

  public static void showIndex(boolean[][] a){
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        StdOut.printf("(%d %d)\t\t",i,j);
      }
      StdOut.println();
    }
  }


  public static void main(String[] args) {
    int gcd  = gcd(1,3);
    StdOut.println(gcd);
    int N = 10;
    boolean[][] a = genArray(N);
    showIndex(a);
    show(a);
//    T	T	T	T	T	T	T	T	T	T
//    F	T	F	T	F	T	F	T	F	T
//    F	T	T	F	T	T	F	T	T	F
//    F	T	F	T	F	T	F	T	F	T
//    F	T	T	T	T	F	T	T	T	T
//    F	T	F	F	F	T	F	T	F	F
//    F	T	T	T	T	T	T	F	T	T
//    F	T	F	T	F	T	F	T	F	T
//    F	T	T	F	T	T	F	T	T	F
  }
}
