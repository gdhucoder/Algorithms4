package leetcode.editor.cn;

/**
 * Created by HuGuodong on 2/11/20.
 */
public class TestCircle {

  public static void main(String[] args) {
    int[] a = {1, 1, 2, 2};
    int val = 2;
    for (int i = 1; i < a.length; i++) {
      val = val & (~a[i]);
      System.out.println(val + "," + a[i]);
    }

  }
}
