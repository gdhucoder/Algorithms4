package Ch_1_2;

/**
 * Created by HuGuodong on 2019/6/22.
 */

public class Ex_1_2_12 {

  public static class _SmartDate {

    private static int[] months = new int[13];

    private static int[] bigmonths = {1, 3, 5, 7, 8, 10, 12};
    private static int[] smallmonth = {4, 6, 9, 11};

    static {
      for (int i = 0; i < bigmonths.length; i++) {
        months[bigmonths[i]] = 31;
      }
      for (int i = 0; i < smallmonth.length; i++) {
        months[smallmonth[i]] = 30;
      }
      months[2] = 28;
    }

    private int year, month, day;

    private static boolean check(int y, int m, int d) {
      if (y < 0) {
        throw new IllegalArgumentException("year must >=0 ");
      }
      if (m < 1 || m > 12) {
        throw new IllegalArgumentException("month 1~12");
      }
      if (isLeapYear(y)) {
        months[2] = 29;
      } else {
        months[2] = 28;
      }
      if (d <= 0 || d > months[m]) {
        throw new IllegalArgumentException(
            String.format("month is %d, day must between 1~%d\n", m, months[m]));
      }
      return true;
    }

    // 能被4整除，但不能被100整除。
    // 能被4整除，也能被400整除。
    private static boolean isLeapYear(int year) {
      if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        return true;
      }
      return false;
    }

    public _SmartDate(int year, int month, int day) {
      check(year, month, day);
      this.year = year;
      this.month = month;
      this.day = day;
    }

    @Override
    public String toString() {
      return "_SmartDate{" +
          "year=" + year +
          ", month=" + month +
          ", day=" + day +
          '}';
    }
  }
}
