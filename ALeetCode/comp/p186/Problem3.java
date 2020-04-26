package ALeetCode.comp.p186;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class Solution {

    int[][] dir = {{1, 0}, {0, 1}};

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
      if (nums.size() == 0) return new int[]{};
      List<Integer> res = new ArrayList<>();
      bfs(nums, res);
      int[] resArr = new int[res.size()];
      for (int i = 0; i < res.size(); i++) {
        resArr[i] = res.get(i);
      }
      return resArr;
    }

    private void bfs(List<List<Integer>> nums, List<Integer> res) {
      Deque<Node> que = new ArrayDeque<>();
      Node n = new Node(nums.get(0).get(0), 0, 0);
      Set<Node> visited = new HashSet<>();
      while (!que.isEmpty()) {
        Node node = que.removeFirst();
        int i = node.i;
        int j = node.j;
        res.add(node.val);
        for (int k = 0; k < 2; k++) {
          int newI = i + dir[k][0];
          int newJ = j + dir[k][1];
          if (isValid(newI, newJ, nums)) {
            que.addLast(new Node(nums.get(newI).get(newJ), newI, newJ));
          }
        }
      }
    }

    private boolean isValid(int i, int j, List<List<Integer>> nums) {
      if (i >= nums.size()) return false;
      if (j >= nums.get(i).size()) return false;
      return true;
    }

    private class Node {

      int val;
      int i;
      int j;

      Node(int val, int i, int j) {
        this.val = val;
        this.i = i;
        this.j = j;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val && i == node.i && j == node.j;
      }

      @Override
      public int hashCode() {
        return Objects.hash(val, i, j);
      }
    }


  }

  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
  }
}
