package Ch_1_4;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Created by HuGuodong on 2019/8/16.
 */

public class Ex_1_4_11 {

  public static class StaticSETofInts {

    private int[] a;

    /**
     * Initializes a set of integers specified by the integer array.
     *
     * @param keys the array of integers
     * @throws IllegalArgumentException if the array contains duplicate integers
     */
    public StaticSETofInts(int[] keys) {

      // defensive copy
      a = new int[keys.length];
      for (int i = 0; i < keys.length; i++)
        a[i] = keys[i];

      // sort the integers
      Arrays.sort(a);
    }

    /**
     * Is the key in this set of integers?
     *
     * @param key the binarySearch key
     * @return true if the set of integers contains the key; false otherwise
     */
    public boolean contains(int key) {
      return rank(key) != -1;
    }

    /**
     * Returns either the index of the binarySearch key in the sorted array (if the key is in the
     * set) or -1 (if the key is not in the set).
     *
     * @param key the binarySearch key
     * @return the number of keys in this set less than the key (if the key is in the set) or -1 (if
     * the key is not in the set).
     */
    public int rank(int key) {
      int lo = 0;
      int hi = a.length - 1;
      while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
          hi = mid - 1;
        else if (key > a[mid])
          lo = mid + 1;
        else
          return mid;
      }
      return -1;
    }

    public int minLeft(int key) {
      int lo = 0;
      int hi = a.length - 1;
      while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
          hi = mid - 1;
        else if (key > a[mid])
          lo = mid + 1;
        else if (mid == 0 || a[mid - 1] != key)
          return mid;
        else
          hi = mid - 1;
      }
      return -1;
    }

    public int maxRight(int key) {
      int lo = 0;
      int hi = a.length - 1;
      while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
          hi = mid - 1;
        else if (key > a[mid])
          lo = mid + 1;
        else if (mid == a.length - 1 || a[mid + 1] != key)
          return mid;
        else
          lo = mid + 1;
      }
      return -1;
    }

    public int howMany(int key) {
      if (rank(key) == -1)
        return 0;
      // key is in the source array
      return maxRight(key) - minLeft(key) + 1;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 2, 2, 3, 4};
    StaticSETofInts set = new StaticSETofInts(a);
    for (int i = 0; i < a.length; i++) {
      if (i > 1 && a[i - 1] == a[i])
        continue;
      int key = a[i];
      StdOut.printf("key %d occurs %d times\n", key, set.howMany(key));
    }
    StdOut.printf("key %d occurs %d times\n", 10, set.howMany(10));
  }
//  key 1 occurs 1 times
//  key 2 occurs 3 times
//  key 3 occurs 1 times
//  key 4 occurs 1 times
//  key 10 occurs 0 times

}
