package ALeetCode.comp.p226;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int countBalls(int lowLimit, int highLimit) {
      int max = 0;
      int[] bin = new int[100];
      for (int i = lowLimit; i <= highLimit; i++) {
        int sum = sumBits(i);
        bin[sum]++;
      }
      for (int n : bin) {
        max = Math.max(n, max);
      }
      return max;
    }

    private static int sumBits(int num) {
      int sum = 0;
      while (num > 0) {
        sum += num % 10;
        num /= 10;
      }
      return sum;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
