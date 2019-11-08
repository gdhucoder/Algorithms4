package geekbang.u39;

/**
 * Created by HuGuodong on 2019/11/8.
 */
public class Pattern {

  private char[] pattern;
  private int plen;
  private boolean match = false;

  public Pattern(char[] pattern, int plen) {
    this.pattern = pattern;
    this.plen = plen;
  }

  public boolean match(char[] text, int tlen) {
    match = false;
    rmatch(0, 0, text, tlen);
    return match;
  }

  private void rmatch(int ti, int pj, char[] text, int tlen) {
    if (match)
      return;
    if (pj == plen) {
      if (ti == tlen)
        match = true;
      return;
    }
    if (pattern[pj] == '*') {
      for (int k = 0; k < tlen - ti; k++) {
        // 匹配剩余任意字符
        rmatch(ti + k, pj + 1, text, tlen);
      }
    } else if (pattern[pj] == '?') {
      // 匹配0个
      rmatch(ti, pj + 1, text, tlen);
      // 匹配1个
      rmatch(ti + 1, pj + 1, text, tlen);
    } else if (ti < tlen && text[ti] == pattern[pj]) {
      // 文本匹配
      rmatch(ti + 1, pj + 1, text, tlen);
    }
  }

  public static void main(String[] args) {
    char[] pattern = "*0*AB?C".toCharArray();
    Pattern p = new Pattern(pattern, pattern.length);
    String s = "1111111111111111111111111111111111111asdfasdf0zzzzzzzABC";
    System.out.println(p.match(s.toCharArray(), s.length()));// true
  }
}
