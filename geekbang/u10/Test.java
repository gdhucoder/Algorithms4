package geekbang.u10;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/2.
 */

public class Test {


  public static int f(int n){
    if (n == 1) {
      return 1;
    }
    return f(n-1) + 1;
  }

  private static int depth = 0;
  public static int stairs(int n){
    depth++;
    StdOut.print(depth+":");
    for (int i = 0; i < depth; i++) {
      StdOut.print("-");
    }
    StdOut.println(n);
    if(n==1) return 1;
    if(n==2) return 2;
    return stairs(n-1) + stairs(n-2);
  }

  @org.junit.Test
  public void testStairs(){
    int N = 10;
    int num = stairs(N);
    StdOut.println(num);
  }

  public static void main(String[] args) {
    int f = f(10);
    StdOut.println(f);
  }
}
