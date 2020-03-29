package ALeetCode.comp.p182_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {

  static class Solution {

    public int findLucky(int[] a) {
      if (a.length == 0) return -1;
      Map<Integer, Integer> map = new HashMap<>();
      for (int n : a) {
        //        if(map.containsKey(n)){
        //          map.put(n, map.get(n)+1);
        //        }else{
        //          map.put(n,1);
        //        }
        map.put(n, map.getOrDefault(n, 0) + 1);
      }
      int max = -1;
      for (Entry<Integer, Integer> e : map.entrySet()) {
        if (e.getValue().equals(e.getKey()) && e.getValue() > max) max = e.getValue();
      }
      return max;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {1, 2, 2, 3, 3, 3};
    System.out.println(s.findLucky(a));
  }
}
