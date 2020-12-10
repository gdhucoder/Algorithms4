//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆 
// 👍 141 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _0373_FindKPairsWithSmallestSumsV0 {

  public static void main(String[] args) {
    Solution solution = new _0373_FindKPairsWithSmallestSumsV0().new Solution();
    int[] n1 = {1, 1, 2};
    int[] n2 = {1, 2, 3};
    System.out.println(solution.kSmallestPairs(n1, n2, 2));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          return o1.get(0) == o2.get(0) ? o1.get(1) - o2.get(1) : o1.get(0) - o2.get(0);
        }
      });
      for (int n1 : nums1) {
        for (int n2 : nums2) {
          List<Integer> pair = new ArrayList<>();
          pair.add(n1);
          pair.add(n2);
          pq.add(pair);
        }
      }
      List<List<Integer>> res = new ArrayList();
      while (!pq.isEmpty() && res.size() <= k) {
        res.add(pq.poll());
      }
      return res;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}