package ALeetCode.comp.p167;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem1 {


  static public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) { val = x; }
  }

  static class Solution {

    public int getDecimalValue(ListNode head) {
      if (head == null) {
        return 0;
      }
      int ret = head.val;
      ListNode x = head.next;
      while (x != null) {

        ret = ret >> 1 + x.val;
        x = x.next;
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = new ListNode(1);
    ListNode h2 = new ListNode(0);
    ListNode h3 = new ListNode(1);
    head.next = h2;
    h2.next = h3;
    System.out.println(s.getDecimalValue(head));
    System.out.println(1 << 1);
  }
}
