package ALeetCode.comp.p241;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minSwaps(String s) {
      boolean hasAns = checkAns(s);
      if (!hasAns) {
        return -1;
      }
      return diffs(s);
    }

    private int diffs(String s) {
      String ans0 = ones(s, false);
      int diff0 = diff(s, ans0);
      String ans1 = ones(s, true);
      int diff1 = diff(s, ans1);
      return Math.min(diff0, diff1);
    }

    private int diff(String s, String ans) {
      int diff = 0;
      for (int i = 0; i < s.length(); i++) {
        if (ans.charAt(i) != s.charAt(i)) {
          diff++;
        }
      }
      int res = diff / 2;
      return (diff % 2 == 0) ? res : res + 1;
    }

    private String ones(String s, boolean isOne) {
      StringBuilder sb = new StringBuilder();
      char ch1 = '0';
      char ch2 = '1';
      if (isOne) {
        ch1 = '1';
        ch2 = '0';
      }
      for (int i = 0; i < s.length(); i++) {
        if (i % 2 == 0) {
          sb.append(ch1);
        }
        else {
          sb.append(ch2);
        }
      }
      return sb.toString();
    }

    private boolean checkAns(String s) {
      int cnt1 = 0;
      int cnt0 = 0;
      for (char c : s.toCharArray()) {
        if (c == '0') {
          cnt0++;
        }
        else {
          cnt1++;
        }
      }
      int diff = Math.abs(cnt1 - cnt0);
      return diff <= 1;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String input = "101111001000101101111100111011100010010000001010010001100010100001111111100111111010001011001010010110111100101100011110010100101110100110101100000000000000010100001011100011110100001111001110101001101100010111001110011001111011100001001110110011101010011111001010001001110001000111001";
    System.out.println(s.minSwaps(input));
  }
}
