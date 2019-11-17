package ALeetCode.comp.p163;

/**
 * Created by HuGuodong on 2019/11/17.
 */
public class Problem2 {

  class TreeNode {

    public TreeNode(int val) {
      this.val = val;
    }

    int val;
    TreeNode left;
    TreeNode right;
  }

  static class FindElements {

    TreeNode root;

    public FindElements(TreeNode root) {
      root.val = 0;
      clean(root);
      this.root = root;
    }

    public void clean(TreeNode n) {
      if (n == null) {
        return;
      }
      if (n.left != null) {
        n.left.val = 2 * n.val + 1;
      }
      if (n.right != null) {
        n.right.val = 2 * n.val + 2;
      }
      clean(n.left);
      clean(n.right);
    }

    public boolean find(int target) {
      return find(root, target);
    }

    public boolean find(TreeNode n, int target) {
      if (n.val == target) {
        return true;
      }
//      if(n.right==null && n.left==null){
//        return false;
//      }
      if (n.left != null) {
        return find(n.left, target);
      }
      if (n.right != null) {
        return find(n.right, target);
      }
      return false;
    }
  }
}
