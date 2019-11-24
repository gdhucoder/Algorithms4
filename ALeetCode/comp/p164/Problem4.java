package ALeetCode.comp.p164;

/**
 * Created by HuGuodong on 11/24/19.
 */
public class Problem4 {

  static class Solution {

    public int result = 0;


    public int numWays(int steps, int arrLen) {
      f(0, arrLen, 0, steps);
      System.out.println(result);
      return result % (int) (Math.pow(10, 9) + 7);
    }

    public void f(int i, int len, int cnt, int stepLimit) {
      //System.out.printf("i->%d len:%d steps: %d\n", i, len, steps);
      if (i < 0 || i >= len || cnt > stepLimit) {
        return;
      } else if (i == 0 && cnt == stepLimit) {
        result++;
        return;
      }

      f(i - 1, len, cnt + 1, stepLimit);

      f(i, len, cnt + 1, stepLimit);

      f(i + 1, len, cnt + 1, stepLimit);

    }


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.numWays(4, 2);
    System.out.println(ans);
  }
}
