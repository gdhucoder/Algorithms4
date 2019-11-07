package ALeetCode;

import geekbang.u40.PackDPv3;

/**
 * Created by HuGuodong on 2019/11/4.
 */
public class P0392 {

  public boolean isSubsequence(String s, String t) {
    if (s.equals(""))
      return true;
    char[] a = s.toCharArray();
    char[] b = t.toCharArray();
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    if (i == a.length) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
//    "acb"
//    "ahbgdc"
    String s = "acb", t = "ahbgdc";
    P0392 p = new P0392();
    System.out.println(p.isSubsequence(s, t));
  }
}
