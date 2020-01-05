package ALeetCode.comp.p170;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    static <K, V extends Comparable<? super V>>
    SortedSet<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
      SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Entry<K, V>>(
          new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
              int res = e1.getValue().compareTo(e2.getValue());
              return res != 0 ? res : 1;
            }
          }
      );
      sortedEntries.addAll(map.entrySet());
      return sortedEntries;
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends,
        int id, int level) {
      // find all ids
      Set<Integer> visited = new HashSet<>();
      visited.add(id);
      int lvl = 0;
//      bfs
      Queue<Integer> que = new LinkedList<>();
      addToQue(friends[id], que);
      while (lvl <= level && !que.isEmpty()) {
        // lvl 0
        int size = que.size();
        for (int i = 0; i < size; i++) {
          int idx = que.poll();
          addToQue(friends[idx], que);
        }
        lvl++;
      }
      if (que.contains(id)) {
        que.remove(id);
      }

      Map<String, Integer> map = new HashMap<>();
      while (!que.isEmpty()) {
        int idx = que.poll();
        List<String> list = watchedVideos.get(idx);
        for (String s : list) {
          if (!map.containsKey(s)) {
            map.put(s, 1);
          } else {
            map.put(s, map.get(s) + 1);
          }
        }
      }
      LinkedHashMap<String, Integer> sortedMap =
          map.entrySet().stream().
              sorted(Entry.comparingByValue()).
              collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap::new));

      Map<Integer, String> reverse = new TreeMap<>((a, b) -> (b - a));
      map.forEach((k, v) -> reverse.put(v, k));
      List<String> res = new ArrayList<>();
      for (String s : sortedMap.keySet()) {
        res.add(s);
      }

      //System.out.println(que.size());

      // res
      return res;
    }

    private void addToQue(int[] friend, Queue<Integer> que) {
      for (int j = 0; j < friend.length; j++) {
        if (!que.contains(friend[j]))
          que.offer(friend[j]);
      }
    }

  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
