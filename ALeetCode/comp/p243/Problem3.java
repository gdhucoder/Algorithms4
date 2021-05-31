package ALeetCode.comp.p243;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    // compare busy, weight, index
    public int[] assignTasks(int[] servers, int[] tasks) {
      int n = servers.length;
      int m = tasks.length;
      int[] res = new int[m];
      Server[] sevs = new Server[n];
      PriorityQueue<Server> que = new PriorityQueue<Server>(new MyComp());
      for (int i = 0; i < n; i++) {
        sevs[i] = new Server(servers[i], i);
        que.add(sevs[i]);
      }
      for (int i = 0; i < m; i++) {
        Server sev = que.poll();
        que.forEach(x -> x.busyUntil += 1);
        sev.busyUntil += i + tasks[i];
        res[i] = sev.index;
        que.add(sev);
      }
      return res;
    }


    class MyComp implements Comparator<Server> {

      @Override
      public int compare(Server s1, Server s2) {
        int diff = s1.busyUntil - s2.busyUntil;
        int wdiff = s1.weight - s2.weight;
        return diff == 0 ? (wdiff == 0 ? s1.index - s2.index : wdiff) : diff;
      }
    }


    private class Server {

      Server(int w, int idx) {
        weight = w;
        index = idx;
      }

      int busyUntil;
      int weight;
      int index;
    }
  }


  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
