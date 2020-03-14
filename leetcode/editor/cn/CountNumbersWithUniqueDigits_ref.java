//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法


package leetcode.editor.cn;

public class CountNumbersWithUniqueDigits_ref {

  public static void main(String[] args) {
    Solution solution = new CountNumbersWithUniqueDigits_ref().new Solution();
    System.out.println(solution.countNumbersWithUniqueDigits(2));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
      // there are 10 unique digits from 0 to 9 to form the numbers,
      // obviousely `count[i] = count[10]` for any i > 10,
      // because there must be at least two digits are the same for a number of length larger than 10.
      if (n > 10) n = 10;
      return getCount(n, 0, new boolean[10]);
    }

    /**
     * @param n
     * @param idx  Possible values of `idx` are in range [0:n]. It means we've assigned `idx` digits
     *             to form the number, and are about to assign the `idx`th digit.
     * @param used A boolean array of length 10 that indicates which digits in [0:9] have been
     *             assigned to form the current number.
     * @return For the top level call, i.e. `idx==0`, the returned value is the count of all valid
     * target numbers. For lower level calls, i.e. `idx > 0`, the returned value is the count of
     * valid target numbers that have the current number as a prefix. The current number is formed
     * by the assigned digits in former calls.
     */
    private int getCount(int n, int idx, boolean[] used) {
      // termination condition: current number contains n digits, we can't add more digits,
      // and there are only one number that has the current number as a prefix, which is the current prefix number itself.
      // A special case is that when n equals 0, there's no prefix number, and the only one number is 0.
      if (idx == n) return 1;
      // initialize count to be 1, because the prefix number itself can be a valid target number.
      // A special case is that when idx equals 0, there's no prefix number, but the number 0 is a valid target number.
      int count = 1;
      // try to add more digits to the prefix number
      for (int i = (idx == 0) ? 1 : 0; i <= 9; i++) {
        if (!used[i]) {    // add the digit if it's not used
          // append `i` to the current number by marking it as used
          used[i] = true;
          // add the count of valid target numbers that have the "updated" current number as a prefix
          count += getCount(n, idx + 1, used);
          // backtrack
          used[i] = false;
        }
      }
      return count;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}