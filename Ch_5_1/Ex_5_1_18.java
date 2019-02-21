package Ch_5_1;

import edu.princeton.cs.algs4.StdRandom;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/22.
 */

public class Ex_5_1_18 {
//  Random decimal keys. Write a static method randomDecimalKeys that takes int values N and W as arguments and returns an array of N string values that are each W-digit decimal numbers.

  public static String[] randomDecimalKeys(int N, int w) {
    String[] a = new String[N];
    StringBuilder s = new StringBuilder(w); // 线程不安全
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < w; j++) {
        s.append(StdRandom.uniform(0, 10));
      }
      a[i] = new String(s.toString());
      s.delete(0, w);
    }
    return a;
  }

  public static void main(String[] args) {
    String[] a = randomDecimalKeys(10, 10);
    PrintUtil.show(a);
  }

}
