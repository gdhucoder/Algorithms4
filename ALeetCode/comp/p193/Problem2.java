package ALeetCode.comp.p193;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int findLeastNumOfUniqueInts(int[] a, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int n : a) {
        map.put(n, map.getOrDefault(n, 0) + 1);
      }
      PriorityQueue<Pair> que = new PriorityQueue<>((o1, o2) -> {
        return o1.times - o2.times;
      });
      for (Entry<Integer, Integer> e : map.entrySet()) {
        que.add(new Pair(e.getKey(), e.getValue()));
      }
      while (k > 0) {
        Pair p = que.peek();
        if (p.times <= k) {
          que.poll();
        }
        k -= p.times;
      }
      return que.size();
    }

    private class Pair {

      int num;
      int times;

      Pair(int num, int times) {
        this.num = num;
        this.times = times;
      }
    }
  }

  public static void main(String[] args) {
    //[4,3,1,1,3,3,2]
    //    3
    Solution s = new Solution();
    int[] a = {4, 3, 1, 1, 3, 3, 2};
    int k = 3;
    System.out.println(s.findLeastNumOfUniqueInts(a, k));
  }
}
