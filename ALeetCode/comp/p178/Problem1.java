package ALeetCode.comp.p178;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    private String fmt = "yyyy-MM-dd";
    private SimpleDateFormat sdf = new SimpleDateFormat(fmt);

    public int daysBetweenDates(String date1, String date2) {
      long res = 0;
      try {
        long time1 = sdf.parse(date1).getTime();
        long time2 = sdf.parse(date2).getTime();
        res = Math.abs(time1 - time2) / (24 * 3600 * 1000);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return (int) res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.daysBetweenDates("2020-01-01", "2020-01-11"));
  }
}
