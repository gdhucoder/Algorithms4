package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/3.
 */

public class Ex_1_3_03 {

  public static boolean possibleSequence(int[] seq) {
    _VarySizedCapacityStack<Integer> stack = new _VarySizedCapacityStack<>();
    boolean[] mark = new boolean[10];
    for (int i = 0; i <= seq[0]; i++) {
      stack.push(i);
      mark[i] = true;
    }

    StdOut.printf("%d ", stack.pop()); // first element

    for (int i = 1; i < seq.length; i++) {
      if ((!stack.isEmpty() && stack.peek() <= seq[i])
          || (stack.isEmpty())) {
        for (int j = 0; j <= seq[i]; j++) {
          if (mark[j] == false) {
            stack.push(j);
            mark[j] = true;
          }
        }
      }
      int pop = stack.pop();
      StdOut.printf("%d ", pop);
      if (pop != seq[i]) {
        StdOut.println("wrong sequence!");
        return false;
      }
    }

    StdOut.println();

    return true;
  }

  public static void main(String[] args) {
    int[][] a = {{4, 3, 2, 1, 0, 9, 8, 7, 6, 5},
        {4, 6, 8, 7, 5, 3, 2, 9, 0, 1},
        {2, 5, 6, 7, 4, 8, 9, 3, 1, 0},
        {4, 3, 2, 1, 0, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 9, 8, 7, 0},
        {0, 4, 6, 5, 3, 8, 1, 7, 2, 9},
        {1, 4, 7, 9, 8, 6, 5, 3, 0, 2},
        {2, 1, 4, 3, 6, 5, 8, 7, 9, 0}};
    for (int i = 0; i < a.length; i++) {
      StdOut.printf("%d : ", i);
      PrintUtil.show(a[i]);
      StdOut.print("    ");
      possibleSequence(a[i]);
    }

//0 : 4 3 2 1 0 9 8 7 6 5
//    4 3 2 1 0 9 8 7 6 5
//1 : 4 6 8 7 5 3 2 9 0 1
//    4 6 8 7 5 3 2 9 1 wrong sequence!
//2 : 2 5 6 7 4 8 9 3 1 0
//    2 5 6 7 4 8 9 3 1 0
//3 : 4 3 2 1 0 5 6 7 8 9
//    4 3 2 1 0 5 6 7 8 9
//4 : 1 2 3 4 5 6 9 8 7 0
//    1 2 3 4 5 6 9 8 7 0
//5 : 0 4 6 5 3 8 1 7 2 9
//    0 4 6 5 3 8 7 wrong sequence!
//6 : 1 4 7 9 8 6 5 3 0 2
//    1 4 7 9 8 6 5 3 2 wrong sequence!
//7 : 2 1 4 3 6 5 8 7 9 0
//    2 1 4 3 6 5 8 7 9 0

  }
}
