//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 
// 👍 166 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class _0172_ExcelSheetColumnNumber {

  public static void main(String[] args) {
    Solution solution = new _0172_ExcelSheetColumnNumber().new Solution();
    System.out.println(solution.titleToNumber("ZY"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    Map<Character, Integer> map = new HashMap<>();

    private void init() {
      for (int i = 1; i <= 26; i++) {
        map.put((char) (64 + i), i);
      }
    }

    public int titleToNumber(String s) {
      init();
      char[] chs = s.toCharArray();
      int res = 0;
      for (int i = 0; i < chs.length; i++) {
        res *= 26;
        res += map.get(chs[i]);
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}