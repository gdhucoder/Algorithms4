# 206. Reverse Linked List





![problem](https://gitee.com/gdhu/testtingop/raw/master/2020-02-12_000.jpg)

```java
class Solution {
    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) return head;
       ListNode cur = head.next;
       ListNode prev = head;
       head.next = null;
       while (cur!=null) {
        ListNode temp = cur;
        cur = cur.next;
        temp.next = prev;
        prev = temp;
       }
       return prev; 
    }
}
```



![&#x9012;&#x5F52;](https://gitee.com/gdhu/testtingop/raw/master/2020-02-12_001.jpg)





