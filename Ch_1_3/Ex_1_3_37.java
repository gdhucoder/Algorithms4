package Ch_1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/25.
 */

public class Ex_1_3_37 {

  // josephus problem
  public static void main(String[] args) {
//    int m = Integer.parseInt(args[0]);
//    int n = Integer.parseInt(args[1]);
    int m = 2;
    int n = 7;

    // initialize the queue
    Queue<Integer> queue = new Queue<Integer>();
    for (int i = 0; i < n; i++)
      queue.enqueue(i);

    while (!queue.isEmpty()) {
      for (int i = 0; i < m - 1; i++)
        queue.enqueue(queue.dequeue());
      StdOut.print(queue.dequeue() + " ");
    }
    StdOut.println();
  }
}
