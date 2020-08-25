package geekbang.designpattern.tools;

import java.util.Random;

/**
 * Created by HuGuodong on 2020/8/22.
 */
public class GenerateNumbers {

  public static void main(String[] args) {
    gen();
  }

  private static void gen() {
    Random r = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 1000; i++) {
      for (int k = 0; k < 5; k++) {
        for (int j = 0; j < 5; j++) {
          if (r.nextDouble() < 0.8) {
            sb.append(r.nextInt(10));
          }
          else {
            sb.append((char) (97 + r.nextInt(26)));
          }

        }
        sb.append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}
