package edu.princeton.cs.myalg.u1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/5/17.
 */

public class Ex_1_1_13 {

  /**
   * use two arrays
   * @param args
   */
  public static void main(String[] args) {
    int M;
    int N;
    M = Integer.parseInt(args[0]);
    N = Integer.parseInt(args[1]);
    int[][] a = new int[M][N];
    for(int i=0; i< M; i++){
      for(int j=0; j<N; j++){
        a[i][j] = i*j;
      }
    }

    for(int i=0; i< M; i++){
      for(int j=0; j<N; j++){
        StdOut.print(a[i][j] = i*j);
        StdOut.print("\t");
      }
      StdOut.println();

    }


    int[][] b = new int[N][M];

    for(int i=0; i< M; i++){
      for(int j=0; j<N; j++){
        b[j][i] = a[i][j];
      }
    }

    for(int i=0; i< N; i++){
      for(int j=0; j<M; j++){
        StdOut.print( b[i][j] );
        StdOut.print("\t");
      }
      StdOut.println();

    }
  }

}
