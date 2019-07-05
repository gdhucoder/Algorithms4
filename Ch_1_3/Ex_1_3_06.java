package Ch_1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/4.
 */

public class Ex_1_3_06 {

  public static void main(String[] args) {
    // init queue
    Queue<String> q = new Queue<>();
    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    q.enqueue("d");
    q.enqueue("e");
    PrintUtil.show(q);

    // reverse order
    Stack<String> stack = new Stack<>();
    while (!q.isEmpty())
      stack.push(q.dequeue());
    while (!stack.isEmpty())
      q.enqueue(stack.pop());

    PrintUtil.show(q);

//    a 	b 	c 	d 	e
//    e 	d 	c 	b 	a

  }
}
