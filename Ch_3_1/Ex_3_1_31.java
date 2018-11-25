package Ch_3_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 2018/11/24.
 */

public class Ex_3_1_31 {

  public static String randomStr() {
    StringBuffer sb = new StringBuffer();
    int len = StdRandom.uniform(2, 51);
    for (int i = 0; i < len; i++) {
      sb.append((char) ('a' + StdRandom.uniform(26)));
    }
    return sb.toString();
  }

  public static void shuffle(Object[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int t = i + StdRandom.uniform(arr.length - i);
      Object temp = arr[i];
      arr[i] = arr[t];
      arr[t] = temp;
    }
  }

  public static void main(String[] args) {

    // ST 中有多少个Key
    int N = 100000;

    // 用个set判断是否在st中
    Set<String> set = new HashSet<>();

    int countForHit = 0;

    Stopwatch stopwatch = new Stopwatch();

    // 组合成一个大数组
    String[] useForInit = new String[2 * N];
    String[] useForHit = new String[N];
    while (countForHit < N) {
      String key = randomStr();
      if (!set.contains(key)) {
        set.add(key);
        useForHit[countForHit] = key;
        useForInit[countForHit] = key;
        countForHit++;
      }
    }

    // 生成N个不在ST中的key
    int countForMiss = 0;
    while (countForMiss < N) {
      String key = randomStr();
      if (!set.contains(key)) {
        useForInit[N + countForMiss++] = key;
      }
    }

    StdOut.println("构建初始化数组，elapsed time: " + stopwatch.elapsedTime());

    stopwatch = new Stopwatch();
    // 打乱
    shuffle(useForInit);
    StdOut.println("乱序，elapsed time: " + stopwatch.elapsedTime());

    stopwatch = new Stopwatch();
    // 初始化st
    BinarySearchST<String, Integer> st = new BinarySearchST<>();
    for (int i = 0; i < N; i++) {
      st.put(useForHit[i], i); // 这道题中，建立一个有序的数组需要花时间很多。
    }

    StdOut.println("构建ST，elapsed time: " + stopwatch.elapsedTime());

    // 测试运行时间
    int M = 10;
    stopwatch = new Stopwatch();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < 2 * N; j++) {
        st.get(useForInit[j]);
      }
    }

    StdOut.println("查询，elapsed time: " + stopwatch.elapsedTime());

    // N = 100000 elapsed time: 0.394
    // N = 1000000 程序就算不动了。

  }
}
