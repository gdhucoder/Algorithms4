package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/2/18.
 */

public class Ex_1_1_11 {

  public static void print(boolean[][] a){

    if(a==null){
      return;
    }

    StdOut.print(" ");
    for (int i = 0; i < a[0].length; i++) {
      StdOut.printf("%3d", i);
    }
    StdOut.println();
    for (int i = 0; i < a.length; i++) {
      StdOut.print(i);
      for (int j = 0; j < a[i].length; j++) {
        if(a[i][j] == true){
          StdOut.printf("%3s", "*");
        }else{
          StdOut.printf("%3s", "-");
        }
      }
      StdOut.println();
    }
  }

  public static boolean[][] genBooleanArr(int M, int N){
    boolean[][] a = new boolean[M][N];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = StdRandom.bernoulli();
      }
    }
    return a;
  }

  public static void main(String[] args) {
    boolean[][] a = genBooleanArr(22,19);
    print(a);

//       0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18
//    0  *  -  -  -  -  -  -  -  -  *  *  -  -  *  -  -  -  -  *
//    1  *  *  -  *  -  -  -  -  -  *  -  -  *  -  -  *  -  -  -
//    2  -  *  *  -  -  *  *  *  *  *  -  -  -  -  *  *  *  -  *
//    3  -  -  -  -  -  *  -  -  *  -  -  *  -  *  *  -  -  -  -
//    4  *  -  -  *  *  *  *  -  *  -  -  -  *  -  -  -  *  *  *
//    5  *  -  *  *  *  *  *  *  *  *  -  -  -  -  *  *  *  -  -
//    6  -  *  *  *  *  -  -  *  *  -  -  -  *  *  -  -  -  *  *
//    7  *  -  *  -  -  -  *  -  -  -  -  *  *  -  *  -  -  -  -
//    8  *  -  -  *  -  *  *  *  *  -  *  *  -  *  *  *  *  -  *
//    9  *  -  *  *  *  -  -  -  -  *  *  -  -  *  -  *  *  -  -
//    10  *  -  -  *  -  -  *  -  *  *  *  -  -  *  *  -  -  -  -
//    11  -  -  *  *  -  *  *  *  *  *  -  *  -  *  -  *  -  -  -
//    12  -  -  *  *  -  *  -  *  *  *  *  *  -  *  *  *  -  *  -
//    13  -  *  *  *  *  *  -  -  *  -  -  -  *  -  -  *  -  *  *
//    14  -  -  *  *  -  -  -  -  -  -  *  -  -  *  -  -  -  -  *
//    15  -  *  *  *  -  *  *  *  *  *  -  *  *  -  -  -  -  *  -
//    16  -  -  *  -  -  *  *  *  *  -  *  *  *  *  -  *  -  -  *
//    17  *  -  *  -  *  -  -  *  *  -  *  *  *  *  -  -  *  -  *
//    18  -  *  -  *  -  *  *  -  *  -  -  -  -  -  *  -  *  *  *
//    19  *  -  -  -  *  -  *  -  *  *  *  -  -  *  -  -  -  *  -
//    20  *  -  *  *  -  *  -  *  -  *  *  *  *  -  *  -  -  -  -
//    21  -  *  -  *  *  *  *  *  -  -  -  -  *  *  -  -  *  -  *

  }
}
