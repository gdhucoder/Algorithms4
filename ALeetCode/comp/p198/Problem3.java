package ALeetCode.comp.p198;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
      int res = 0;
      res += numBottles;
      while (numBottles >= numExchange) {
        res += numBottles / numExchange;
        numBottles = numBottles / numExchange + numBottles % numExchange;
      }
      return res;
    }
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println(s.numWaterBottles(15, 4));
    System.out.println(s.numWaterBottles(9, 3));
  }
}
