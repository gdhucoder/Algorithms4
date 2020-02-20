# 155. Min Stack

[155. Min Stack ](https://leetcode-cn.com/problems/min-stack/)

```text
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

{% tabs %}
{% tab title="Java 6ms" %}
```java
// use linked list, and insert a front a head, then keep min in each node.
class MinStack {

    /** initialize your data structure here. */
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
    return  head.val;
  }

  public int getMin() {
    return  head.min;
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
```
{% endtab %}

{% tab title="Java 12ms" %}
```java
// use 2 stacks
class MinStack {

private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();

  /**
   * initialize your data structure here.
   */
  public MinStack() {

  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty()) minStack.push(x);
    else if (!minStack.isEmpty() && minStack.peek() >= x) {
        minStack.push(x);
    }
  }

  public void pop() {
    int pop = stack.pop();
    if (pop==minStack.peek()) {
        minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```
{% endtab %}
{% endtabs %}

