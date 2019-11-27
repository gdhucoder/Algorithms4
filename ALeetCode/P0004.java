package ALeetCode;

/**
 * Created by HuGuodong on 11/27/19.
 */
public class P0004 {

  static class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      if (nums1.length == 0 && nums2.length == 0) {
        return 0;
      } else if (nums1.length == 0 && nums2.length != 0) {
        return mid(nums2);
      } else if (nums1.length != 0 && nums2.length == 0) {
        return mid(nums1);
      } else {
        return (mid(nums1) + mid(nums2)) / 2;
      }
    }

    public int mid(int[] a) {
      int mid = 0;
      if (a.length % 2 == 0) {
        mid = (int) ((a[a.length / 2] + a[a.length / 2 - 1])) / 2;
      } else {
        mid = a[a.length / 2];
      }
      System.out.println(mid);
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2};
    int[] b = {3, 4};
    Solution s = new Solution();
    double mid = s.findMedianSortedArrays(a, b);
    System.out.println(mid);
  }
}
