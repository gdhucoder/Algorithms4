package ALeetCode.interview.t01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2020/6/4.
 */
public class ProblemHW03 {

  static final Set<Integer> SET_2_5 = new HashSet<>();
  static final Set<Integer> SET_6_9 = new HashSet<>();
  static final Map<Integer, Integer> NUMS_MAP = new HashMap<>();
  static final Map<Integer, Integer> INDEX_MAP = new HashMap<>();
  static final int NUM_0 = 0;
  static final int NUM_2 = 2;
  static final int NUM_5 = 5;
  static final int NUM_6 = 6;
  static final int NUM_9 = 9;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String input = sc.nextLine();
      String[] numStrs = input.split(",");
      int[] arr = new int[numStrs.length];

      for (int i = 0; i < numStrs.length; i++) {
        arr[i] = Integer.parseInt(numStrs[i]);
      }
      preCheck(arr);
      if (NUMS_MAP.containsKey(NUM_0)) {
        System.out.println(-1);
      }
      else if (NUMS_MAP.containsKey(NUM_2) && NUMS_MAP.containsKey(NUM_5)) {
        System.out.println(-1);
      }
      else if (NUMS_MAP.containsKey(NUM_6) && NUMS_MAP.containsKey(NUM_9)) {
        System.out.println(-1);
      }
      else {
        List<int[]> allArrs = getArr(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int[] subArr : allArrs) {
          int len = subArr.length;
          generateCombo(0, arr, new boolean[len], new ArrayList<>(), res);
        }
        res.sort(new Comparator<List<Integer>>() {
          @Override
          public int compare(List<Integer> o1, List<Integer> o2) {
            if (o1.size() == o2.size()) {
              for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i) == (o2.get(i))) {
                  continue;
                }
                else {
                  return o1.get(i) - o2.get(i);
                }
              }
              return 0;
            }
            else {
              return o1.size() - o2.size();
            }
          }
        });
        int max = findMax(allArrs);
        System.out.println(max);
        List<Integer> maxList = res.get(max);
        //        System.out.println(res);
        int printNum = covertListToInt(maxList);
        System.out.println(printNum);
      }
    }
  }

  private static List<int[]> getArr(int[] arr) {
    List<int[]> res = new ArrayList<>();
    res.add(copy(arr));
    if (NUMS_MAP.containsKey(NUM_2)) {
      int[] temp = copy(arr);
      temp[INDEX_MAP.get(NUM_2)] = 5;
      res.add(temp);
      if (NUMS_MAP.containsKey(NUM_6)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_6)] = 9;
        res.add(temp);
      }
      if (NUMS_MAP.containsKey(NUM_9)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_9)] = 6;
        res.add(temp);
      }
    }
    if (NUMS_MAP.containsKey(NUM_5)) {
      int[] temp = copy(arr);
      temp[INDEX_MAP.get(NUM_5)] = 2;
      res.add(temp);
      if (NUMS_MAP.containsKey(NUM_6)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_6)] = 9;
        res.add(temp);
      }
      if (NUMS_MAP.containsKey(NUM_9)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_9)] = 6;
        res.add(temp);
      }
    }
    if (NUMS_MAP.containsKey(NUM_6)) {
      int[] temp = copy(arr);
      temp[INDEX_MAP.get(NUM_6)] = 9;
      res.add(temp);
      if (NUMS_MAP.containsKey(NUM_5)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_5)] = 2;
        res.add(temp);
      }
      if (NUMS_MAP.containsKey(NUM_2)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_2)] = 5;
        res.add(temp);
      }
    }
    if (NUMS_MAP.containsKey(NUM_9)) {
      int[] temp = copy(arr);
      temp[INDEX_MAP.get(NUM_9)] = 6;
      res.add(temp);
      if (NUMS_MAP.containsKey(NUM_5)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_5)] = 2;
        res.add(temp);
      }
      if (NUMS_MAP.containsKey(NUM_2)) {
        temp = copy(arr);
        temp[INDEX_MAP.get(NUM_2)] = 5;
        res.add(temp);
      }
    }

    System.out.println(res.size());
    for (int[] a : res) {
      PrintUtil.show(a);
    }
    return res;
  }

  private static int[] copy(int[] a) {
    int[] res = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      res[i] = a[i];
    }
    return res;
  }

  private static void bfs(int[] nums, List<List<Integer>> res) {

  }


  private static void generateCombo(int lvl, int[] nums, boolean[] used, List<Integer> combo,
      List<List<Integer>> res) {
    // terminate
    res.add(new ArrayList<>(combo));
    if (lvl == nums.length) {
      return;
    }
    //
    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        used[i] = true;
        combo.add(nums[i]);
        generateCombo(lvl + 1, nums, used, combo, res);
        combo.remove(combo.size() - 1);
        used[i] = false;
      }
    }


  }


  private static int findMax(List<int[]> arr) {
    int max = -1;
    for (int[] a : arr) {
      for (int n : a) {
        max = Math.max(n, max);
      }
    }

    return max;
  }

  private static int covertListToInt(List<Integer> list) {
    int sum = 0;
    for (int n : list) {
      sum = sum * 10 + n;
    }
    return sum;
  }

  private static void init() {
    SET_2_5.add(2);
    SET_2_5.add(5);
    SET_6_9.add(6);
    SET_6_9.add(9);
  }

  private static void preCheck(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int n = a[i];
      NUMS_MAP.put(n, NUMS_MAP.getOrDefault(n, 0) + 1);
      INDEX_MAP.put(n, i);
    }
  }
}
