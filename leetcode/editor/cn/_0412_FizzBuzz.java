//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “_0412_FizzBuzz”。
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "_0412_FizzBuzz"
//]
// 
// 👍 71 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _0412_FizzBuzz {

  public static void main(String[] args) {
    Solution solution = new _0412_FizzBuzz().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<String> fizzBuzz(int n) {
      String fiz = "Fizz";
      String buz = "Buzz";
      String fbz = "_0412_FizzBuzz";
      List<String> res = new ArrayList<>(n);
      for (int i = 1; i <= n; i++) {
        if (i % 15 == 0) {
          res.add(fbz);
        }
        else if (i % 3 == 0) {
          res.add(fiz);
        }
        else if (i % 5 == 0) {
          res.add(buz);
        }
        else {
          res.add(String.valueOf(i));
          // "" + i is slow...
        }
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}