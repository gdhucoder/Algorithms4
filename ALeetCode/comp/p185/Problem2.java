package ALeetCode.comp.p185;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    private Set<String> foods = new TreeSet<>();
    private Map<String, Map<String, Integer>> tables = new TreeMap<>();

    public List<List<String>> displayTable(List<List<String>> orders) {
      if (orders.size() == 0) return Collections.emptyList();
      for (List<String> order : orders) {
        foods.add(order.get(2));
        if (!tables.containsKey(order.get(1))) tables.put(order.get(1), new HashMap<>());
      }

      for (Entry<String, Map<String, Integer>> entry : tables.entrySet()) {
        Map<String, Integer> table = entry.getValue();
        for (String food : foods) {
          table.put(food, 0);
        }
      }

      for (List<String> order : orders) {
        Map<String, Integer> table = tables.get(order.get(1));
        table.put(order.get(2), table.get(order.get(2)) + 1);
      }

      List<List<String>> res = new ArrayList<>();

      for (Entry<String, Map<String, Integer>> entry : tables.entrySet()) {
        List<String> row = new ArrayList<>();
        row.add("" + entry.getKey());
        Map table = entry.getValue();
        for (String food : foods) {
          row.add("" + table.get(food));
        }
        res.add(row);
      }
      Collections.sort(res, (o1, o2) -> Integer.valueOf(o1.get(0)) - Integer.valueOf(o2.get(0)));

      List<String> head = new ArrayList<>();
      head.add("Table");
      head.addAll(foods);
      res.add(0, head);
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
    Map<Integer, Map<String, Integer>> tables = new TreeMap<>();
    tables.put(1, new HashMap<>());
    tables.put(2, new HashMap<>());
    tables.put(3, new HashMap<>());
    System.out.println(tables.size());
  }
}
