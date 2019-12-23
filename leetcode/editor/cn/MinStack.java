//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

public class MinStack {

  public static void main(String[] args) {
    MinStack s = new MinStack();
    for (int i = 0; i < 15; i++) {
      s.push(i);
    }
    for (int i = 0; i < 15; i++) {
      System.out.println(s.top());
      s.pop();

    }
    System.out.println(s);
  }

//leetcode submit region begin(Prohibit modification and deletion)

  /**
   * initialize your data structure here.
   */
  private Node head;

  public MinStack() {

  }

  public void push(int x) {
    if (head == null) {
      head = new Node(x, x, null);
    } else {
      head = new Node(x, Math.min(head.min, x), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  private class Node {

    public Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }

    int val;
    int min;
    Node next;
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
