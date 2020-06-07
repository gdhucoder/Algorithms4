//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n 的 最简 分数 。分数可以以 任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：["1/2"]
//解释："1/2" 是唯一一个分母小于等于 2 的最简分数。 
//
// 示例 2： 
//
// 输入：n = 3
//输出：["1/2","1/3","2/3"]
// 
//
// 示例 3： 
//
// 输入：n = 4
//输出：["1/2","1/3","1/4","2/3","3/4"]
//解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。 
//
// 示例 4： 
//
// 输入：n = 1
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _1447_SimplifiedFractions {

  public static void main(String[] args) {
    Solution solution = new _1447_SimplifiedFractions().new Solution();
    solution.simplifiedFractions(4);
    System.out.println(solution.gcd(3, 2));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> simplifiedFractions(int n) {
      var res = new ArrayList<String>();
      var set = new HashSet<Double>();
      for (var i = 2; i <= n; i++) {
        for (var j = 1; j < i; j++) {
          var val = (double) j / i;
          if (!set.contains(val)) {
            res.add(j + "/" + i);
            set.add(val);
          }
        }
      }
      // System.out.println(res);
      return res;
    }

    public List<String> simplifiedFractions1(int n) {
      List<String> res = new ArrayList<>();
      var set = new HashSet<Double>();
      for (int i = 2; i <= n; i++) {
        for (int j = 1; j < i; j++) {
          double val = i / j;
          if (!set.contains(val)) {
            res.add(String.format("%d/%d", j, i));
            set.add(val);
          }
        }
      }
      System.out.println(res);
      return res;
    }

    public int gcd(int a, int b) {
      if (b == 0) {
        return a;
      }
      return gcd(b, a % b);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}