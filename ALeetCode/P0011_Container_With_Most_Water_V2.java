package ALeetCode;

/**
 * 双指针法 Created by HuGuodong on 11/28/19.
 */
public class P0011_Container_With_Most_Water_V2 {

  static class Solution {

    public int maxArea(int[] height) {
      int[] a = height;
      int max = -1;
      int l = 0;
      int r = a.length - 1;
      while (l < r) {
        max = Math.max(max, Math.min(a[l], a[r]) * (r - l));
        if (a[l] > a[r]) { // 因为如果选向左移动，不会使得面积进一步增加。
          r--;
        } else {
          l++;
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
