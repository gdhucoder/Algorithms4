//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 972 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class _0013_RomanToInteger {

  public static void main(String[] args) {
    Solution solution = new _0013_RomanToInteger().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
      init();
      int res = 0;
      for (int i = 0; i < s.length(); ) {
        String key = s.substring(i, i + 1 < s.length() ? i + 2 : s.length());
        if (key.length() == 2 && map.containsKey(key)) {
          res += map.get(key);
          i += 2;
        }
        else {
          res += map.get(s.substring(i, i + 1));
          i += 1;
        }
      }
      return res;
    }

    private void init() {
      map.put("I", 1);
      map.put("V", 5);
      map.put("X", 10);
      map.put("L", 50);
      map.put("C", 100);
      map.put("D", 500);
      map.put("M", 1000);
      map.put("IV", 4);
      map.put("IX", 9);
      map.put("XL", 40);
      map.put("XC", 90);
      map.put("CD", 400);
      map.put("CM", 900);
    }


  }
  //leetcode submit region end(Prohibit modification and deletion)

}