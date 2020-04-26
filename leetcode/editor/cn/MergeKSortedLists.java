//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package leetcode.editor.cn;

import java.util.PriorityQueue;

public class MergeKSortedLists {

  public static void main(String[] args) {
    Solution solution = new MergeKSortedLists().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) return null;
      PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
      for (ListNode node : lists) {
        if (node != null) queue.add(node);
      }
      ListNode dummyHead = new ListNode(-1);
      ListNode cur = dummyHead;
      while (!queue.isEmpty()) {
        ListNode min = queue.poll();
        cur.next = min;
        cur = min;
        if (cur.next != null) {
          queue.add(cur.next);
        }
      }
      return dummyHead.next;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}