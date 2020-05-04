package ALeetCode.comp.p187;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem4 {

  static class Solution {

    Set<List<String>> visited = new HashSet<>();

    public String destCity(List<List<String>> paths) {
      if (paths.isEmpty()) return "";
      return dfs(paths, paths.get(0).get(0));
    }

    private String dfs(List<List<String>> paths, String start) {

      for (List<String> path : paths) {
        if (!visited.contains(path) && path.get(0).equals(start)) {
          visited.add(path);
          dfs(paths, path.get(1));
        }
      }
      return start;
    }


  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println();
  }
}
