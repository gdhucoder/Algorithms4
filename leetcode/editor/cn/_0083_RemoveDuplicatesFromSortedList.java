//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 369 👎 0


package leetcode.editor.cn;

public class _0083_RemoveDuplicatesFromSortedList {

  public static void main(String[] args) {
    Solution solution = new _0083_RemoveDuplicatesFromSortedList().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode deleteDuplicates(ListNode head) {
      ListNode cur = head;
      while (cur != null && cur.next != null) {
        if (cur.val == cur.next.val) {
          cur.next = cur.next.next;
        }
        else {
          cur = cur.next;
        }
      }
      return head;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}