//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心算法 动态规划


package leetcode.editor.cn;

import java.util.Arrays;

public class _1405_LongestHappyString_v2 {

  public static void main(String[] args) {
    Solution solution = new _1405_LongestHappyString_v2().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {


    public String longestDiverseString(int a, int b, int c) {
      MyChar[] myChars = new MyChar[]{new MyChar('a', a), new MyChar('b', b), new MyChar('c', c),};
      StringBuilder sb = new StringBuilder();
      while (true) {
        Arrays.sort(myChars);
        //先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置次多的字符
        int len = sb.length();
        if (len >= 2 && sb.charAt(len - 1) == myChars[2].ch
            && sb.charAt(len - 2) == myChars[2].ch) {
          if (myChars[1].count == 0) break;
          myChars[1].count--;
          sb.append(myChars[1].ch);
        }
        else {
          if (myChars[2].count == 0) break;
          myChars[2].count--;
          sb.append(myChars[2].ch);
        }
      }

      return sb.toString();
    }

    private class MyChar implements Comparable {

      char ch;
      int count;

      MyChar(char ch, int count) {
        this.ch = ch;
        this.count = count;
      }

      @Override
      public int compareTo(Object o) {
        MyChar other = (MyChar) o;
        return this.count - other.count;
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}