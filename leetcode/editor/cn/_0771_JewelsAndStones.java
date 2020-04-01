//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。 
//
// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。 
//
// 示例 1: 
//
// 输入: J = "aA", S = "aAAbbbb"
//输出: 3
// 
//
// 示例 2: 
//
// 输入: J = "z", S = "ZZ"
//输出: 0
// 
//
// 注意: 
//
// 
// S 和 J 最多含有50个字母。 
// J 中的字符不重复。 
// 
// Related Topics 哈希表


package leetcode.editor.cn;

public class _0771_JewelsAndStones {

  public static void main(String[] args) {
    Solution solution = new _0771_JewelsAndStones().new Solution();
    System.out.println((int) 'A'); // 65
    System.out.println((int) 'Z'); // 90
    System.out.println((int) 'a'); // 97
    System.out.println((int) 'z'); // 122

  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int numJewelsInStones(String J, String S) {
      if (J.length() == 0 || S.length() == 0) return 0;
      char[] jewels = J.toCharArray();
      char[] stones = S.toCharArray();
      int[] jTypes = new int[52];
      for (char c : jewels) {
        if (c >= 'a' && c <= 'z') jTypes[c - 'a']++;
        else jTypes[c - 'A' + 26]++;
      }
      int sum = 0;
      for (char c : stones) {
        if ((c >= 'a' && c <= 'z' && jTypes[c - 'a'] > 0) || (c >= 'A' && c <= 'Z'
            && jTypes[c - 'A' + 26] > 0)) sum++;
      }

      return sum;
      //leetcode submit region end(Prohibit modification and deletion)
    }
  }
}