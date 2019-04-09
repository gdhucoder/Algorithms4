package Ch_1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/4/10.
 */

public class Ex_1_1_23 {

  // java Ch_1_1.Ex_1_1_23 tinyW.txt - < tinyT.txt
  // java Ch_1_1.Ex_1_1_23 tinyW.txt + < tinyT.txt
  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();
    String op = args[1];
    Arrays.sort(whitelist);
    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int rank = Ex_1_1_22.rank(whitelist, key);
      if (rank > 0 && op.equals("-")) { // in white list
        StdOut.println(key);
      } else if (rank == -1 && op.equals("+")) {//not in white list
        StdOut.println(key);
      }
    }

  }
}
