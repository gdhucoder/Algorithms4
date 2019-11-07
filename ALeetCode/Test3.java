package ALeetCode;

/**
 * Created by HuGuodong on 2019/11/4.
 */
public class Test3 {

  public boolean lemonadeChange(int[] bills) {
    int[] income = new int[3];
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        income[0] += 1;
      } else if (bills[i] == 10) {
        income[0] -= 1;
        income[1] += 1;
      } else {
        income[2] += 1;
        if (income[1] >= 1) {
          income[1] -= 1;
          income[0] -= 1;
        } else {
          income[0] -= 3;
        }
      }
    }
    for (int j = 0; j < income.length; j++) {
      if (income[j] < 0) {
        return false;
      }
    }
    return true;
  }
}
