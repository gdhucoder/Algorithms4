//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？ 
//
// 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。 
//
// 你允许： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空 
// 
//
// 示例 1: (From the famous "Die Hard" example) 
//
// 输入: x = 3, y = 5, z = 4
//输出: True
// 
//
// 示例 2: 
//
// 输入: x = 2, y = 6, z = 5
//输出: False
// 
// Related Topics 数学 
// 👍 232 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class _0365_WaterAndJugProblem {

  public static void main(String[] args) {
    Solution solution = new _0365_WaterAndJugProblem().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
      if (z == 0) return true;
      if (x + y < z) return false;
      State initState = new State(0, 0);
      Queue<State> queue = new LinkedList<>();
      Set<State> visited = new HashSet<>();
      queue.offer(initState);
      visited.add(initState);
      while (!queue.isEmpty()) {
        State head = queue.poll();

        int curX = head.getX();
        int curY = head.getY();

        if (curX == z || curY == z || curX + curY == z) {
          return true;
        }

        List<State> nextStates = getNextStates(curX, curY, x, y);

        for (State nextState : nextStates) {
          if (!visited.contains(nextState)) {
            queue.offer(nextState);
            visited.add(nextState);
          }
        }
      }
      return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {
      List<State> nextStates = new ArrayList<>(8);

      State nextState1 = new State(x, curY); // 装满A
      State nextState2 = new State(curX, y);// 装满B

      State nextState3 = new State(0, curY);
      State nextState4 = new State(curX, 0);

      // 四个状态
      State nextState5 = new State(curX - (y - curY), y); // 从A到B，B满 A 还有剩余
      State nextState6 = new State(0, curX + curY);

      State nextState7 = new State(x, curY - (x - curX)); // 倒满A，B有剩余
      State nextState8 = new State(curX + curY, 0);

      if (curX < x) {
        nextStates.add(nextState1);
      }
      if (curY < y) {
        nextStates.add(nextState2);
      }

      if (curX > 0) nextStates.add(nextState3);
      if (curY > 0) nextStates.add(nextState4);

      if (curX - (y - curY) > 0) {
        nextStates.add(nextState5);
      }

      if (curY - (x - curX) > 0) {
        nextStates.add(nextState7);
      }

      if (curX + curY < y) nextStates.add(nextState6);
      if (curX + curY < x) nextStates.add(nextState8);

      return nextStates;

    }

    private class State {

      private int x;
      private int y;

      public State(int x, int y) {
        this.x = x;
        this.y = y;
      }

      public int getX() {
        return x;
      }

      public void setX(int x) {
        this.x = x;
      }

      public int getY() {
        return y;
      }

      public void setY(int y) {
        this.y = y;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return x == state.x && y == state.y;
      }

      @Override
      public int hashCode() {
        return Objects.hash(x, y);
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}