package Ch_5_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/26.
 */

public class _RKSearch {

  // 假设为数值字符串
  private static int R = 10;

  public static int hash(String key) {
    int h = 0;
    for (int i = 0; i < key.length(); i++) {
      h = h * R + (key.charAt(i) - '0');
    }
    return h;
  }

  public static int searchV1(String txt, String pat) {
    int N = txt.length();
    int M = pat.length();
    int hash = hash(pat);
    for (int i = 0; i <= N - M; i++) {
      // 计算每个子串的哈希值
      int subHash = hash(txt.substring(i, i + M));
      if (hash == subHash) {
        return i;
      }
    }

    return N;
  }

  /**
   * 显示搜索结果
   * @param txt
   * @param pat
   * @param n
   */
  public static void showSearch(String txt, String pat, int n) {
    if (n >= 0 && n < txt.length()) {
      for (int i = 0; i < n; i++) {
        StdOut.print(" ");
      }
      StdOut.println(pat);
    } else {
      StdOut.println("pat not found!");
    }
  }

  public static void main(String[] args) {
    int hash = hash("26535");
    StdOut.println(hash); // 结果为26535
    String txt = "3131592653589793";
    String pat = "26535";
    // 匹配的位置
    int n = searchV1(txt, pat);
    StdOut.println(txt);
    showSearch(txt, pat, n);
//  搜索的字符串为：
//    3131592653589793
//          26535

  }


}
