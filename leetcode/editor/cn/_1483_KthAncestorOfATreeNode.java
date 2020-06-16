//给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0
// 的节点。 
//
// 请你设计并实现 getKthAncestor(int node, int k) 函数，函数返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节
//点，返回 -1 。 
//
// 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。 
//
// 
//
// 示例： 
//
// 
//
// 输入：
//["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
//[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
//
//输出：
//[null,1,0,-1]
//
//解释：
//TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
//
//treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
//treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
//treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 5*10^4 
// parent[0] == -1 表示编号为 0 的节点是根节点。 
// 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立 
// 0 <= node < n 
// 至多查询 5*10^4 次 
// 
// Related Topics 动态规划


package leetcode.editor.cn;

public class _1483_KthAncestorOfATreeNode {

  public static void main(String[] args) {
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class TreeAncestor {

    int maxPow;
    int[][] jump;

    public TreeAncestor(int n, int[] parent) {
      maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
      jump = new int[maxPow][n];
      jump[0] = parent;
      for (int p = 1; p < maxPow; p++) {
        for (int j = 0; j < n; j++) {
          int pre = jump[p - 1][j];
          jump[p][j] = pre == -1 ? -1 : jump[p - 1][pre];
        }
      }
    }

    public int getKthAncestor(int node, int k) {
      int maxPow = this.maxPow;
      while (k > 0 && node > -1) {
        if (k >= 1 << maxPow) {
          node = jump[maxPow][node];
          k -= 1 << maxPow;
        }
        else {
          maxPow -= 1;
        }
      }
      return node;
    }
  }

  /**
   * Your TreeAncestor object will be instantiated and called as such:
   * TreeAncestor obj = new TreeAncestor(n, parent);
   * int param_1 = obj.getKthAncestor(node,k);
   */
  //leetcode submit region end(Prohibit modification and deletion)

}