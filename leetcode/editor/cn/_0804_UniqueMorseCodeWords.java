//国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c
//" 对应 "-.-.", 等等。 
//
// 为了方便，所有26个英文字母对应摩尔斯密码表如下： 
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","-
//-","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--
//.."] 
//
// 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" +
// "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。 
//
// 返回我们可以获得所有词不同单词翻译的数量。 
//
// 例如:
//输入: words = ["gin", "zen", "gig", "msg"]
//输出: 2
//解释: 
//各单词翻译如下:
//"gin" -> "--...-."
//"zen" -> "--...-."
//"gig" -> "--...--."
//"msg" -> "--...--."
//
//共有 2 种不同翻译, "--...-." 和 "--...--.".
// 
//
// 
//
// 注意: 
//
// 
// 单词列表words 的长度不会超过 100。 
// 每个单词 words[i]的长度范围为 [1, 12]。 
// 每个单词 words[i]只包含小写字母。 
// 
// Related Topics 字符串


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class _0804_UniqueMorseCodeWords {

  public static void main(String[] args) {
    Solution solution = new _0804_UniqueMorseCodeWords().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int uniqueMorseRepresentations(String[] words) {
      String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
          "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
          "-..-", "-.--", "--.."};
      Set<String> set = new HashSet<>();
      StringBuilder morseCode = new StringBuilder();
      for (String word : words) {
        for (char c : word.toCharArray()) {
          morseCode.append(codes[c - 'a']);
        }
        set.add(morseCode.toString());
        morseCode.delete(0, morseCode.length());
      }
      return set.size();
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}