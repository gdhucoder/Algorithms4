package ALeetCode.interview.t01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by HuGuodong on 2020/6/4.
 */
public class ProblemHW02 {

  static final String CHAR_SET_STR = "aeiouAEIOU";
  static final Set<Character> CHAR_SET = new HashSet<>();

  public static void main(String[] args) {
    init();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String input = sc.nextLine();
      int res = maxLen(input);
      System.out.println(res);
    }
  }

  /**
   * dp, use an extra array to save len of aeiuo..
   *
   * @param s
   * @return
   */
  public static int maxLen(String s) {
    char[] chs = s.toCharArray();
    int[] dp = new int[chs.length];
    dp[0] = CHAR_SET.contains(chs[0]) ? 1 : 0;
    int maxLen = dp[0];
    for (int i = 1; i < chs.length; i++) {
      dp[i] = CHAR_SET.contains(chs[i]) ? (dp[i - 1] + 1) : 0;
      maxLen = Math.max(dp[i], maxLen);
    }
    return maxLen;
  }

  /**
   * init char set
   */
  private static void init() {
    for (char c : CHAR_SET_STR.toCharArray()) {
      CHAR_SET.add(c);
    }
  }
}
