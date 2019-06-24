package Ch_1_2;

import edu.princeton.cs.algs4.In;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/6/24.
 */

public class Ex_1_2_15 {

  public static int[] readInts(String name) {
    In in = new In(name);
    String input = in.readAll();
    String[] words = input.split("\\s+");
    int[] ints = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      ints[i] = Integer.parseInt(words[i]);
    }
    return ints;
  }

  public static void main(String[] args) {
    int[] ints = readInts("E:\\gitspace\\x1c\\Alg4\\algs4\\src\\main\\java\\Ch_1_2\\Ex_1_2_15.txt");
//    content in file :
//    1 2 3   4 6 7 9 10       11
    PrintUtil.show(ints);
//    [1, 2, 3, 4, 6, 7, 9, 10, 11]

  }

}
