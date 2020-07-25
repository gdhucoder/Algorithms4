//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// 👍 24 👎 0


package leetcode.editor.cn;

public class _1360_NumberOfDaysBetweenTwoDates {

  public static void main(String[] args) {
    Solution solution = new _1360_NumberOfDaysBetweenTwoDates().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private final int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int[] daysInYear = {365, 366};

    public int daysBetweenDates(String date1, String date2) {
      return Math.abs(days(date1) - days(date2));
    }

    private int days(String date) {
      String[] dates = date.split("-");
      int year = Integer.parseInt(dates[0]), mon = Integer.parseInt(dates[1]), day = Integer
          .parseInt(dates[2]);
      int isLeap = leap(year);
      int sum = 0;
      for (int i = 1971; i < year; i++) {
        sum += (365 + leap(i));
      }
      for (int i = 1; i < mon; i++) {
        sum += (month[i] + (i == 2 ? isLeap : 0));
      }
      sum += day;
      return sum;
    }

    private int leap(int year) {
      if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) return 1;
      return 0;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}