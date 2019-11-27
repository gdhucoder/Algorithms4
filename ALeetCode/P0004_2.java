package ALeetCode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/ Created by HuGuodong on 11/27/19.
 */
public class P0004_2 {

  static class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] temp = new int[nums1.length + nums2.length];
      for (int i = 0; i < nums1.length; i++) {
        temp[i] = nums1[i];
      }
      for (int i = nums1.length; i < nums1.length + nums2.length; i++) {
        temp[i] = nums2[i - nums1.length];
      }
      Arrays.sort(temp);
      return mid(temp);

    }

    public double mid(int[] a) {
      double mid = 0;
      if (a.length % 2 == 0) {
        mid = ((a[a.length / 2] + a[a.length / 2 - 1])) / 2.0;
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
