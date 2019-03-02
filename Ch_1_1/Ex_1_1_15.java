package Ch_1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_15 {
  public static int[] histogram(int[] a, int M){
    int[] ret = new int[M];
    for (int i = 0; i < a.length; i++) {
      ret[a[i]]++;
    }
    return ret;
  }

  public static void main(String[] args) {
    
    int M = StdRandom.uniform(50);
    
    int[] a = new int[100];
    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform(M);
    }
    PrintUtil.show(a);
    int[] b = histogram(a, M);
    PrintUtil.show(b);
//    [2, 3]

    int sum = 0;
    for (int i = 0; i < b.length; i++) {
      sum += b[i];
    }

    StdOut.println("sum == a.length? " + (sum == a.length));
//    [12, 29, 7, 14, 14, 44, 6, 9, 40, 8, 26, 0, 36, 39, 17, 8, 39, 25, 16, 8, 7, 16, 9, 20, 41, 15, 0, 21, 38, 17, 34, 12, 27, 13, 28, 8, 42, 23, 10, 17, 7, 27, 8, 7, 45, 13, 41, 33, 26, 33, 17, 26, 33, 19, 39, 22, 3, 44, 23, 42, 42, 35, 35, 37, 0, 10, 25, 31, 23, 10, 28, 5, 30, 20, 9, 29, 15, 45, 10, 38, 33, 43, 26, 21, 39, 37, 40, 6, 33, 23, 16, 11, 39, 44, 25, 7, 20, 34, 35, 36]
//[3, 0, 0, 1, 0, 1, 2, 5, 5, 3, 4, 1, 2, 2, 2, 2, 3, 4, 0, 1, 3, 2, 1, 4, 0, 3, 4, 2, 2, 2, 1, 1, 0, 5, 2, 3, 2, 2, 2, 5, 2, 2, 3, 1, 3, 2]
//    sum == a.length? true


  }
}
;
