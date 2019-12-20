//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列

package leetcode.editor.cn;

public class DesignCircularDeque {

  public static void main(String[] args) {
    MyCircularDeque deque = new DesignCircularDeque().new MyCircularDeque(8);
    System.out.println(deque.insertFront(3));
    ;
    System.out.println(deque.getFront());
    System.out.println(deque.deleteFront());
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class MyCircularDeque {

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */


    public MyCircularDeque(int k) {
      this.size = k;
      head = new Node(-1);
      tail = new Node(-1);
      head.next = tail;
      tail.prev = head;
    }


    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
      if (isFull()) {
        return false;
      }
      new Node(value, head, head.next);
      count++;
      return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
      if (isFull()) {
        return false;
      }
      new Node(value, tail.prev, tail);
      count++;
      return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
      if (isEmpty()) {
        return false;
      }

      Node node = head.next;

      head.next = head.next.next;
      head.next.prev = head;
      node.prev = null;
      node.next = null;
      count--;
      return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
      if (isEmpty()) {
        return false;
      }

      Node node = tail.prev;

      tail.prev = tail.prev.prev;
      tail.prev.next = tail;

      node.prev = null;
      node.next = null;

      count--;
      return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
      if (isEmpty()) {
        return -1;
      }
      return head.next.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
      if (isEmpty()) {
        return -1;
      }
      return tail.prev.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
      return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
      return count == size;
    }

    private int size;
    private int count = 0;
    private Node head;
    private Node tail;

    private class Node {

      Node prev;
      Node next;
      int val;

      public Node(int val) {
        this.val = val;
      }

      public Node(int val, Node prev, Node next) {
        this(val);
        this.prev = prev;
        this.next = next;
        prev.next = this;
        next.prev = this;
      }

      @Override
      public String toString() {
        return val + "";
      }
    }

  }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}