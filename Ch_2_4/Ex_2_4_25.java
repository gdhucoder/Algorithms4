package Ch_2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/6.
 */
/******************************************************************************
 *  Compilation:  javac CubeSum.java
 *  Execution:    java CubeSum n
 *  Dependencies: MinPQ.java
 *
 *  Print out integers of the form a^3 + b^3 in sorted order, where
 *  0 <= a <= b <= n.
 *
 *  % java CubeSum 10
 *  0 = 0^3 + 0^3
 *  1 = 0^3 + 1^3
 *  2 = 1^3 + 1^3
 *  8 = 0^3 + 2^3
 *  9 = 1^3 + 2^3
 *  ...
 *  1729 = 9^3 + 10^3
 *  1729 = 1^3 + 12^3
 *  ...
 *  3456 = 12^3 + 12^3
 *
 *  Remarks
 *  -------
 *   - Easily extends to handle sums of the form f(a) + g(b)
 *   - Prints out a sum more than once if it can be obtained
 *     in more than one way, e.g., 1729 = 9^3 + 10^3 = 1^3 + 12^3
 *
 ******************************************************************************/

public class Ex_2_4_25 {

  static class CubeSum implements Comparable<CubeSum>{
    int sum;
    int i;
    int j;

    CubeSum(int i, int j){
      this.i = i;
      this.j = j;
      sum = i*i*i+j*j*j;
    }

    @Override
    public int compareTo(CubeSum o) {
      return sum>o.sum? +1
            :sum <o.sum? -1
            : 0;
    }

    @Override
    public String toString() {
      return sum + " = " + i+"^3"+ "+"+ j+"^3";
    }
  }

  public static void main(String[] args) {

    int count = 0;

    int n = 10;

    MinPQ<CubeSum> pq = new MinPQ<>();

    for(int i=0; i<=n; i++){
      pq.insert(new CubeSum(i,i)); // 保证： 0 <= a <= b <= n. 初始化时应该j=i
      // 这样就不能输出
//      1512 = 8^3+10^3
//      1512 = 10^3+8^3 (*) 这种情况了
    }

    while (!pq.isEmpty()){
      count++;
      CubeSum sum = pq.delMin();
      StdOut.println(sum);
      if(sum.j<n){
        CubeSum newSum = new CubeSum(sum.i, sum.j+1);
        pq.insert(newSum);
        StdOut.println("inserting: " + newSum);
      }
    }
    StdOut.println("count: " + count);
  }

}
