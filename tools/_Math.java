package tools;

/**
 * Created by HuGuodong on 2019/11/3.
 */
public class _Math {

  private _Math() {

  }

  public static int min(int... args) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < args.length; i++) {
      if (args[i] < min) {
        min = args[i];
      }
    }
    return min;
  }
}
