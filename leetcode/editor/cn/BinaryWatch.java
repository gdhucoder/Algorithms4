//二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 案例: 
//
// 
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 注意事项: 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 
// Related Topics 位运算 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryWatch {

  public static void main(String[] args) {
    Solution solution = new BinaryWatch().new Solution();
    solution.readBinaryWatch(2);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public void init() {
      map.put(0, 1);
      map.put(1, 2);
      map.put(2, 4);
      map.put(3, 8);
      map.put(4, 1);
      map.put(5, 2);
      map.put(6, 4);
      map.put(7, 8);
      map.put(8, 16);
      map.put(9, 32);
    }

    boolean[] mark = new boolean[10];
    int n;

    public List<String> readBinaryWatch(int num) {
      n = num;
      init();
      helper(0, new ArrayList<>());
      return null;
    }

    private void helper(int level, ArrayList<Integer> res) {
      if (level == n) {
        System.out.println(res);
        return;
      }
      for (int i = 0; i < 10; i++) {
        if (!mark[i]) {
          res.add(map.get(i));
          helper(level + 1, res);
          res.remove(res.size() - 1);
          //          mark[i] = false;
        }
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}