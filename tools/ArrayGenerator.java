package tools;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/10/24.
 */

public class ArrayGenerator {

  public static Random random = new Random();

  public ArrayGenerator() {}


  /**
   * [a, b)
   */
  public static double[] genRandomDoules(int N, double lower, double upper) {
    double[] vals = new double[N];
    for (int i = 0; i < N; i++) {
      vals[i] = StdRandom.uniform(lower, upper);
    }
    return vals;
  }

  public static Integer[] duplicateKeysIntArray(int size, int keys) {
    Integer[] a = new Integer[size];
    for (int i = 0; i < a.length; i++) {
      // [0,n)
      a[i] = StdRandom.uniform(keys);
    }
    return a;

  }


  /**
   * @param hi
   * @return
   */
  public static Integer[] randomIntArray(int hi) {
    Integer[] a = ascIntArray(hi);
    StdRandom.shuffle(a);
    return a;
  }

  /**
   * @param lo
   * @param hi
   * @return
   */
  public static Integer[] randomIntArray(int lo, int hi) {
    Integer[] a = ascIntArray(lo, hi);
    StdRandom.shuffle(a);
    return a;
  }

  /**
   * [start, end]
   */
  public static Integer[] ascIntArray(int lo, int hi) {
    int length = hi - lo + 1;
    Integer[] arr = new Integer[length];
    for (int i = 0; i < length; i++) {
      arr[i] = i + lo;
    }
    return arr;
  }

  /**
   * [0, end]
   */
  public static int[] ascInts(int hi) {
    return ascInts(0, hi);
  }

  /**
   * [start, end]
   */
  public static int[] ascInts(int lo, int hi) {
    int length = hi - lo + 1;
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = i + lo;
    }
    return arr;
  }

  public static int[] ascInts(int lo, int hi, int num) {

    if (hi < lo) {
      throw new IllegalArgumentException("low must less than low");
    }

    int[] a = new int[num];
    for (int i = 0; i < a.length; i++) {
      if (hi == lo) {
        a[i] = lo;
      } else {
        a[i] = random.nextInt(hi - lo + 1) + lo;
      }
    }
    Arrays.sort(a);
    return a;
  }

  public static double[] randomDoubleArray(int hi, int size) {
    double[] a = new double[size];
    for (int i = 0; i < size; i++) {
      a[i] = StdRandom.uniform(0d, hi);
    }
    return a;
  }

  public static int[] randomIntsArray(int hi) {
    int[] a = ascInts(0, hi);
    StdRandom.shuffle(a);
    return a;
  }

  public static int[] randomIntsArray(int lo, int hi) {
    int[] a = ascInts(lo, hi);
    StdRandom.shuffle(a);
    return a;
  }

  public static Integer[] ascIntArray(int hi) {
    return ascIntArray(0, hi);
  }

  public static Integer[] descIntArray(int lo, int hi) {
    Integer[] arr = ascIntArray(lo, hi);
    Arrays.sort(arr, Comparator.reverseOrder());
    return arr;
  }

  public static Integer[] descIntArray(int hi) {
    return descIntArray(0, hi);
  }

  public static Integer[] fixedValueIntArray(int val, int size) {
    Integer[] arr = new Integer[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = val;
    }
    return arr;
  }

  public static Integer[] stringToIntArray(String str) {
    String[] arr = str.split(" ");
    Integer[] a = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++) {
      a[i] = Integer.valueOf(arr[i]);
    }
    return a;
  }

  /**
   * Generate uniform random Integer Array [lo,hi]
   */
  public static Integer[] Integers(int size, int lo, int hi) {

    if (size < 0) {
      throw new IllegalArgumentException("size can not be less than 0");
    }
    if (lo > hi) {
      throw new IllegalArgumentException("lo can not be larger than hi");
    }
    if (hi > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("hi can not be larger than Integer.MAX_VALUE");
    }

    Integer[] arr = new Integer[size];

    for (int i = 0; i < size; i++) {
      arr[i] = StdRandom.uniform(lo, hi + 1);
    }

    return arr;

  }

  public static int[] intsArray(int size, int lo, int hi) {

    if (size < 0) {
      throw new IllegalArgumentException("size can not be less than 0");
    }
    if (lo > hi) {
      throw new IllegalArgumentException("lo can not be larger than hi");
    }
    if (hi > Integer.MAX_VALUE) {
      throw new IllegalArgumentException("hi can not be larger than Integer.MAX_VALUE");
    }

    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      arr[i] = StdRandom.uniform(lo, hi + 1);
    }

    return arr;

  }

  /**
   * Generate uniform random Integer Array [0,hi]
   */
  public static Integer[] Integers(int size, int hi) {
    return Integers(size, 0, hi);
  }


  public static void show(Object[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static int[] allSameInts(int size, int key) {
    if (size <= 0) {
      throw new IllegalArgumentException("size can not be less than 0");
    }

    int[] arr = new int[size];
    Arrays.fill(arr, key);
    return arr;
  }

  public static Integer[] intsToInteger(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("null argument or zero element array!");
    }
    Integer[] a = new Integer[arr.length];
    for (int i = 0; i < a.length; i++) {
      a[i] = arr[i];
    }

    return a;

  }

  /**
   * 生成含有若干个key的数组。
   */
  public static int[] intsWithNkeys(int size, int... keys) {
    if (size <= 0 || keys == null) {
      throw new IllegalArgumentException("size can not be less than 0 Or keys is null");
    }
    int a[] = new int[size];
    int count = keys.length;
    for (int i = 0; i < size; i++) {
      a[i] = keys[StdRandom.uniform(count)];
    }
    return a;
  }


}
