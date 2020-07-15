//给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。 
//
// 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有： 
//
// 
// 如果 S[i] == "I"，那么 A[i] < A[i+1] 
// 如果 S[i] == "D"，那么 A[i] > A[i+1] 
// 
//
// 
//
// 示例 1： 
//
// 输出："IDID"
//输出：[0,4,1,3,2]
// 
//
// 示例 2： 
//
// 输出："III"
//输出：[0,1,2,3]
// 
//
// 示例 3： 
//
// 输出："DDI"
//输出：[3,2,0,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 10000 
// S 只包含字符 "I" 或 "D"。 
// 
// Related Topics 数学 
// 👍 150 👎 0


package leetcode.editor.cn;

public class _0942_DiStringMatch {

  public static void main(String[] args) {
    Solution solution = new _0942_DiStringMatch().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] diStringMatch(String s) {
      int n = s.length(), lo = 0, hi = n;
      char[] chs = s.toCharArray();
      int[] res = new int[n + 1];
      for (int i = 0; i < chs.length; i++) {
        res[i] = chs[i] == 'I' ? lo++ : hi--;
      }
      res[n] = lo;
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}