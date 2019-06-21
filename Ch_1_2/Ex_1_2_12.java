package Ch_1_2;

import static Ch_1_2.Ex_1_2_12._SmartDate.dayOfTheWeek;

import edu.princeton.cs.algs4.StdOut;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public static int dayOfTheWeek(int y, int m, int d) {
      int y0 = y - (14 - m) / 12;
      int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
      int m0 = m + 12 * ((14 - m) / 12) - 2;
      int d0 = (d + x + (31 * m0) / 12) % 7;
      return d0;
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

  public static void main(String[] args) {
    String format = "MM/dd/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM-yyyy G");
    Calendar c = Calendar.getInstance();
    c.set(1, Calendar.JANUARY, 1);
    System.out.println(c.get(Calendar.DAY_OF_WEEK)); // 7 表示 Saturday
    StringBuffer buf = new StringBuffer();
    sdf.format(c.getTime(), buf, new FieldPosition(0));
    System.out.println(buf);
    _SmartDate date = new _SmartDate(2019, 6, 22);
    int d = dayOfTheWeek(2019, 6, 22);
    StdOut.println(d); // 6 表示Saturday
    d = dayOfTheWeek(1, 1, 1); // 是星期1？ 这个不准了
    StdOut.println(d);
//    7
//    星期六 22-06-2019 公元
//    6
  }
}
