package Ch_5_1;

import static Ch_5_1.Ex_5_1_20.randomFixedLengthWords;

import edu.princeton.cs.algs4.StdRandom;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/22.
 */

public class Ex_5_1_21 {
//  Random items. Write a static method randomItems that takes an int value N as  argument and returns an array of N string values that are each strings of length between 15 and 30 made up of three fields: a 4-character field with one of a set of 10 fixed strings; a 10-char field with one of a set of 50 fixed strings; a 1-character field with one of two given values; and a 15-byte field with random left-justified strings of letters equally likely to be 4 through 15 characters long.

  public static String[] randomItems(int N) {
    String[] a = new String[N];
    String[] _4characterSet = randomFixedLengthWords(10, 4);
    String[] _10characterSet = randomFixedLengthWords(50, 10);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(_4characterSet[StdRandom.uniform(10)]) // 4 character
          .append(_10characterSet[StdRandom.uniform(50)]) // 10 character
          .append(StdRandom.bernoulli(0.5) == true ? "1" : "0"); // 1 character
      int w = StdRandom.uniform(4, 16); // 4-15 character
      for (int j = 0; j < w; j++) {
        sb.append((char) ('a' + StdRandom.uniform(26)));
      }
      a[i] = sb.toString();
      sb.delete(0, 15 + w); // clear sb
    }
    return a;
  }

  public static void main(String[] args) {
    String[] a = randomItems(10000);
    PrintUtil.show(a, "\n");
  }

}
