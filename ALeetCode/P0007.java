package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/11.
 */
public class P0007 {

  public static int reverse(int x) {
    if (x == 0) {
      return 0;
    }
    String s = "" + x;
    boolean minus = false;
    if (s.startsWith("-")) {
      minus = true;
      s = s.substring(1, s.length());
    }

    char[] a = s.toCharArray();
    for (int i = 0; i < a.length / 2; i++) {
      swap(a, i, a.length - 1 - i);
    }
    int zero_cnt = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != '0') {
        break;
      } else {
        zero_cnt++;
      }
    }

    s = new String(a);
    s = s.substring(zero_cnt);
    if (minus) {
      s = "-" + s;
    }
    if (Double.parseDouble(s) < Integer.MIN_VALUE || Double.parseDouble(s) >= Integer.MAX_VALUE) {
      return 0;
    } else {
      return (int) Double.parseDouble(s);
    }

  }

  private static void swap(char[] a, int i, int j) {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int a = -1020000;
    System.out.println(reverse(a));
  }
}
