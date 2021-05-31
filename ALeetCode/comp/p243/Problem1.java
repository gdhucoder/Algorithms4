package ALeetCode.comp.p243;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
      return (sum(firstWord) + sum(secondWord)) == sum(targetWord);
    }

    private static int sum(String ss) {
      String sum = "";
      for (char c : ss.toCharArray()) {
        sum += "" + (c - 'a');
      }
      return Integer.parseInt(sum);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
