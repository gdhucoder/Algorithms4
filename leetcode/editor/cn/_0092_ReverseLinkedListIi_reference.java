//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package leetcode.editor.cn;

import edu.princeton.cs.algs4.StdOut;

public class _0092_ReverseLinkedListIi_reference {

  /**
   * https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
   *
   * @param args
   */
  public static void main(String[] args) {
    Solution solution = new _0092_ReverseLinkedListIi_reference().new Solution();
    ListNode n = new ListNode(1);
    ListNode head = n;
    for (int i = 2; i <= 7; i++) {
      n.next = new ListNode(i);
      n = n.next;
    }
    solution.reverseBetween(head, 2, 5);
    while (head != null) {
      StdOut.printf("%d, ", head.val);
      head = head.next;
    }
    System.out.println(head);

  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null)
        return null;
      ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
      dummy.next = head;
      ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
      for (int i = 0; i < m - 1; i++)
        pre = pre.next;

      ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
      ListNode then = start.next; // a pointer to a node that will be reversed

      // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
      // dummy-> 1 -> 2 -> 3 -> 4 -> 5

      for (int i = 0; i < n - m; i++) {
        start.next = then.next;
        then.next = pre.next;
        pre.next = then;
        then = start.next;
      }

      // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
      // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

      return dummy.next;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}