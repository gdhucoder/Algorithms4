package ALeetCode.interview.interviewzs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 招商银行 笔试 Created by HuGuodong on 2020/6/14.
 */
public class Problem1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      String input = in.nextLine();
      char[] chs = f(input.toCharArray());
      System.out.println(new String(chs));
    }
  }

  private static char[] f(char[] in) {
    char[] res = new char[in.length];
    int j = in.length - 1;
    for (int i = in.length - 1; i >= 0; i--) {
      if (in[i] > '*') {
        res[j] = in[i];
        j--;
      }
    }
    Arrays.fill(res, 0, j + 1, '*');
    return res;
  }

}
