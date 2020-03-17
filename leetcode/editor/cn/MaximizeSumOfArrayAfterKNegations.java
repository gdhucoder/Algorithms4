//给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次
//选择同一个索引 i。） 
//
// 以这种方式修改数组后，返回数组可能的最大和。 
//
// 
//
// 示例 1： 
//
// 输入：A = [4,2,3], K = 1
//输出：5
//解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
// 
//
// 示例 2： 
//
// 输入：A = [3,-1,0,2], K = 3
//输出：6
//解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
// 
//
// 示例 3： 
//
// 输入：A = [2,-3,-1,5,-4], K = 2
//输出：13
//解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= K <= 10000 
// -100 <= A[i] <= 100 
// 
// Related Topics 贪心算法


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {

  public static void main(String[] args) {
    Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
    int[] a = {2, -3, -1, 5, -4};
    int K = 2;
    int sum = solution.largestSumAfterKNegations(a, K);
    System.out.println(sum);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int largestSumAfterKNegations(int[] arr, int k) {
      Arrays.sort(arr); // asc: 负数...0..0..正数
      int sum = 0, len = arr.length, minIndex = 0; // 初始第一个最小
      while (k > 0) {
        arr[minIndex] = -arr[minIndex]; // 最小者取反
        k--;
        // 维护最小值索引
        // 若后面还有数，则看当前的与下一个谁更小
        if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) minIndex++;
      }
      for (int i : arr) sum += i;
      return sum;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}