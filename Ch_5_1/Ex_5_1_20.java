package Ch_5_1;

import edu.princeton.cs.algs4.StdRandom;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/2/22.
 */

public class Ex_5_1_20 {
  public static String[] randomFixedLengthWords(int N, int w){
    if (N <= 0 || w <= 0) {
      throw new IllegalArgumentException("N and w must greater than 0.");
    }
    String[] a = new String[N];
    StringBuilder sb = new StringBuilder(w);
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < w; j++) {
        sb.append((char) ('a' + StdRandom.uniform(26)));
      }
      a[i] = sb.toString();
      sb.delete(0, w);
    }
    return a;
  }

  public static void main(String[] args) {
    int N = 10;
    int w = 8;
    String[] a = randomFixedLengthWords(N, w);
    PrintUtil.show(a);
//    ilgxxqci	gtoeficd	wbbmkqzs	vlwjrzbp	wfkbbiua	azliqgjx	xacpzzjr	qrtikgki	aonjmjul	osjeokga
  }
}
