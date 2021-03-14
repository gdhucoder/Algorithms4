package ALeetCode.comp.p231;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minElements(int[] nums, int limit, int goal) {
      long sum = sum(nums);
      long sub = Math.abs((long) goal - sum);
      long res = sub / limit + (sub % limit == 0 ? 0 : 1);
      return (int) res;
    }

    private static long sum(int[] nums) {
      long sum = 0;
      for (int num : nums) {
        sum += num;
      }
      return sum;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {1, -1, 1};
    int limit = 3;
    int goal = -4;

    System.out.println(s.minElements(a, limit, goal));
  }
}
