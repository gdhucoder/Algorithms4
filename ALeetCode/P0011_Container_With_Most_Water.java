package ALeetCode;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/ Created by HuGuodong on 11/28/19.
 */
public class P0011_Container_With_Most_Water {

  static class Solution {

    public int maxArea(int[] height) {
      int[] a = height;
      int n = a.length;
      int max = -1;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          int area = Math.min(a[i], a[j]) * (j - i);
          if (area > max) {
            max = area;
          }
        }
      }
      return max;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int ans = s.maxArea(a);
    System.out.println(ans);
  }
}
