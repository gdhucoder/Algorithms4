//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

  public static void main(String[] args) {
    Solution solution = new SubarraySumsDivisibleByK().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int subarraysDivByK(int[] A, int K) {
      Map<Integer, Integer> record = new HashMap<>();
      record.put(0, 1);
      int sum = 0, ans = 0;
      for (int elem : A) {
        sum += elem;
        // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
        int modulus = (sum % K + K) % K;
        int same = record.getOrDefault(modulus, 0);
        ans += same;
        record.put(modulus, same + 1);
      }
      return ans;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}