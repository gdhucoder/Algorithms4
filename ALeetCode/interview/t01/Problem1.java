package ALeetCode.interview.t01;

import java.util.Scanner;

/**
 * Created by HuGuodong on 2020/6/4.
 */
public class Problem1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    char[] chs = str.toCharArray();
    for (int i = chs.length - 1; i >= 0; i--) {
      System.out.print(chs[i]);
    }
  }

}
