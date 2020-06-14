package ALeetCode.interview.interviewzs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 招商银行 笔试 Created by HuGuodong on 2020/6/14.
 */
public class Problem2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
      int n = Integer.parseInt(in.nextLine());
      int[] arr = convertToArr(in.nextLine());
      List<List<Integer>> res = new ArrayList<>();
      boolean[] used = new boolean[n];
      Arrays.sort(arr);
      //      PrintUtil.show(arr);
      helper(0, arr, n, new ArrayList<>(), 0, res, used);
      System.out.println(res.size());
    }
  }


  private static void helper(int lvl, int[] a, int n, List<Integer> list, int sum,
      List<List<Integer>> res, boolean[] used) {
    if (list.size() > n || sum > 24) {
      return;
    }
    if (sum == 24) {
      System.out.println(list);
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = lvl; i < n; i++) {
      if (used[i]) continue;
      //      if (i >= 1 && a[i] == a[i - 1] && used[i-1] &) continue;
      sum += a[i];
      list.add(a[i]);
      used[i] = true;
      helper(i, a, n, list, sum, res, used);
      sum -= a[i];
      used[i] = false;
      list.remove(list.size() - 1);
    }
  }

  private static int[] convertToArr(String input) {
    String[] arr = input.split(" ");
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = Integer.parseInt(arr[i]);
    }
    return res;
  }
}
