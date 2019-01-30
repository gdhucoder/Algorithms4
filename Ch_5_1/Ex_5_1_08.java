package Ch_5_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/1/31.
 */

public class Ex_5_1_08 {

  private static String[] genArr(int N){
    String[] a = new String[N];
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; i++) {
      sb.append('a');
      a[i] = sb.toString();
    }
    return a;
  }

  public static void show(String[] a){
    for (String s : a){
      StdOut.print(s+"\t");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    int N = 10;
    String[] a = genArr(N);
    show(a);
    _MSD.sort(a);
    show(a);
    _Quick3String.sort(a);
    show(a);

  }
}
