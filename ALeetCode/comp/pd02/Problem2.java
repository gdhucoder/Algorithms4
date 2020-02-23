package ALeetCode.comp.pd02;

import java.math.BigDecimal;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Cashier {

    int freq;
    int discount;
    int[] products = new int[201];
    int[] prices = new int[201];
    int totalTimes;

    public Cashier(int n, int discount, int[] products, int[] prices) {
      this.freq = n;
      this.discount = discount;
      for (int i = 0; i < 201; i++) {
        this.products[i] = i;
      }
      for (int i = 0; i < products.length; i++) {
        this.prices[products[i]] = prices[i];
      }
      this.totalTimes = 0;
    }

    public double getBill(int[] product, int[] amount) {
      BigDecimal sum = BigDecimal.ZERO;
      for (int i = 0; i < product.length; i++) {

        sum = sum.add(BigDecimal.valueOf(prices[product[i]] * amount[i]));
        //        sum += prices[product[i] - 1];
      }
      totalTimes++;
      if (totalTimes != 0 && totalTimes % freq == 0) {
        sum = sum
            .subtract(sum.multiply(BigDecimal.valueOf(discount)).divide(BigDecimal.valueOf(100)));
      }
      return sum.doubleValue();
    }


  }

  static class Solution {

  }

  public static void main(String[] args) {
    Solution s = new Solution();

    Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7},
        new int[]{100, 200, 300, 400, 300, 200, 100});
    double sum = cashier.getBill(new int[]{1, 2}, new int[]{1, 2});
    System.out.println(sum);
    sum = cashier.getBill(new int[]{3, 7}, new int[]{10, 10});
    System.out.println(sum);
  }
}
