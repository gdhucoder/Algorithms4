package ALeetCode.interview.interviewzs;

import java.util.Scanner;

/**
 * Created by HuGuodong on 2020/6/14.
 */
public class ProblemEx {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
      int a = in.nextInt();
      int b = in.nextInt();
      System.out.println(a + b);
    }
  }
}
