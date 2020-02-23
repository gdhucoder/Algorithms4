package ALeetCode.comp.p178;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
      int[] indeg = new int[n];
      int[] outdeg = new int[n];
      for (int i = 0; i < n; i++) {
        if (leftChild[i] != -1) {
          outdeg[i]++;
          indeg[leftChild[i]]++;
        }
        if (rightChild[i] != -1) {
          outdeg[i]++;
          indeg[rightChild[i]]++;
        }
      }
      int z = 0;
      for (int i = 0; i < n; i++) {
        if (indeg[i] > 1) return false;
        if (indeg[i] == 0) z++;
      }
      if (z != 1) return false;
      return true;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println();
  }
}
