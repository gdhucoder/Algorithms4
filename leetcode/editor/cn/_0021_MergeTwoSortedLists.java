//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

public class _0021_MergeTwoSortedLists {

  public static void main(String[] args) {
    Solution solution = new _0021_MergeTwoSortedLists().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      return mergeRecursion(l1, l2);
    }

    public ListNode mergeRecursion(ListNode l1, ListNode l2) {
      if (l1 == null) { // corner
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      if (l1.val < l2.val) {
        l1.next = mergeRecursion(l1.next, l2);
        System.out.println(l1.val);
        return l1;
      } else {
        l2.next = mergeRecursion(l1, l2.next);
        System.out.println(l2.val);
        return l2;
      }
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}