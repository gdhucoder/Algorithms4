package Ch_1_4;

/**
 * Created by HuGuodong on 2019/8/14.
 */

public class Ex_1_4_07 {

  public static int count(int[] a) {
    int N = a.length;
    int cnt = 0;
    // 2N
    for (int i = 0; i < N; i++) {
      // N^2
      for (int j = i + 1; j < N; j++) {
        // j+1 N^2 times, k<N C(N,3) times, k++ C(N,3) times
        for (int k = j + 1; k < N; k++) {
          // add: C(N,3) times , equals test: C(N,3) times
          if (a[i] + a[j] + a[k] == 0) {
            cnt++;
          }
        }
      }
    }
    return cnt;
  }
}
