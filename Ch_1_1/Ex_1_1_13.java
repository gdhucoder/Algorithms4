package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/2/18.
 */

public class Ex_1_1_13 {
//  1.1.13 Write a code fragment to print the transposition (rows and columns changed)
//  of a two-dimensional array with M rows and N columns.

  /**
   * 转置数组
   * @param a
   * @return
   */
  public static int[][] transpose(int[][] a){
    if(a==null){
      return null;
    }
    int M = a.length;
    int N = a[0].length;
    int[][] trans = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        trans[i][j] = a[j][i];
      }
    }
    return trans;
  }

  /**
   * generate a random int array
   * @param M
   * @param N
   * @return
   */
  public static int[][] genRandomIntArr(int M, int N){
    int[][] a = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        a[i][j] = StdRandom.uniform(0,10);
      }
    }
    return a;
  }

  /**
   * print array
   * @param a
   */
  public static void print(int[][] a){
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        StdOut.printf("%3d", a[i][j]);
      }
      StdOut.println();
    }
  }

  public static void main(String[] args) {
    int[][] a = genRandomIntArr(10,20);
    StdOut.println("转置前：");
    print(a);
    StdOut.println("转置后：");
    a = transpose(a);
    print(a);
//    转置前：
//    6  4  9  4  9  1  5  7  1  5  2  2  1  8  6  6  0  5  0  5
//    3  8  0  6  2  3  1  3  6  1  8  6  4  0  9  8  9  7  6  7
//    5  4  9  2  3  8  7  3  7  4  2  0  1  1  6  4  2  7  3  9
//    1  7  1  2  4  4  4  0  7  4  4  9  5  2  4  6  4  4  2  5
//    7  3  8  3  1  8  9  5  7  3  4  9  4  6  3  3  2  4  3  5
//    0  0  8  2  4  2  4  7  5  6  6  9  4  4  7  8  1  7  4  4
//    2  4  0  4  3  3  2  4  2  1  2  1  9  0  1  1  1  2  1  9
//    7  6  2  4  0  3  5  4  4  9  8  6  7  6  1  8  6  5  4  0
//    6  6  9  3  3  6  3  6  0  8  8  1  3  3  6  6  8  9  6  1
//    5  7  5  0  6  7  6  0  6  8  2  6  0  3  4  3  2  7  0  0
//    转置后：
//    6  3  5  1  7  0  2  7  6  5
//    4  8  4  7  3  0  4  6  6  7
//    9  0  9  1  8  8  0  2  9  5
//    4  6  2  2  3  2  4  4  3  0
//    9  2  3  4  1  4  3  0  3  6
//    1  3  8  4  8  2  3  3  6  7
//    5  1  7  4  9  4  2  5  3  6
//    7  3  3  0  5  7  4  4  6  0
//    1  6  7  7  7  5  2  4  0  6
//    5  1  4  4  3  6  1  9  8  8
//    2  8  2  4  4  6  2  8  8  2
//    2  6  0  9  9  9  1  6  1  6
//    1  4  1  5  4  4  9  7  3  0
//    8  0  1  2  6  4  0  6  3  3
//    6  9  6  4  3  7  1  1  6  4
//    6  8  4  6  3  8  1  8  6  3
//    0  9  2  4  2  1  1  6  8  2
//    5  7  7  4  4  7  2  5  9  7
//    0  6  3  2  3  4  1  4  6  0
//    5  7  9  5  5  4  9  0  1  0
  }

}
