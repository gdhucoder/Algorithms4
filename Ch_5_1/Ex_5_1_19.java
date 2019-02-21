package Ch_5_1;

import edu.princeton.cs.algs4.StdRandom;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/22.
 */

public class Ex_5_1_19 {

//  Random CA license plates. Write a static method randomPlatesCA that takes an int value N as argument and returns an array of N String values that represent CA license plates as in the examples in this section.

  public static String[] randomPlatesCA(int N) {
    String[] a = new String[N];
    int w = 7;
    StringBuilder s = new StringBuilder(w);
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < w; j++) {
        if (j == 0) {
          s.append(StdRandom.uniform(5));
        } else if (j >= 1 && j <= 3) {
          s.append((char) ('A' + StdRandom.uniform(26)));
        } else {
          s.append(StdRandom.uniform(10));
        }
      }
      a[i] = s.toString();
      s.delete(0, w);
    }
    return a;
  }

  public static void main(String[] args) {
    String[] a = randomPlatesCA(10);
    PrintUtil.show(a);
//    2FNQ241	4KNP401	1MDF105	3ETS853	1FSO429	3JQG889	3NJW707	4RCY858	2RNP072	2OAJ817
  }

}
