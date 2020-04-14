//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0445_AddTwoNumbersIi {

  public static void main(String[] args) {
    Solution solution = new _0445_AddTwoNumbersIi().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      Deque<Integer> stack1 = new ArrayDeque<>();
      Deque<Integer> stack2 = new ArrayDeque<>();
      while (l1 != null) {
        stack1.addLast(l1.val);
        l1 = l1.next;
      }
      while (l2 != null) {
        stack2.addLast(l2.val);
        l2 = l2.next;
      }
      ListNode head = null, temp = null;
      int a = 0, b = 0, carry = 0;
      while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
        a = stack1.isEmpty() ? 0 : stack1.removeLast();
        b = stack2.isEmpty() ? 0 : stack2.removeLast();
        int val = a + b + carry;
        int cur = val % 10;
        carry = val / 10;
        temp = new ListNode(cur);
        temp.next = head;
        head = temp;
      }
      return head;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}