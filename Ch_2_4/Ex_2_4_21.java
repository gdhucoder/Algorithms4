package Ch_2_4;

import static tools.ArrayGenerator.ascIntArray;

import Ch_2_4.Ex_2_4_19.MaxPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.HashSet;
import java.util.Random;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/10/24.
 */

public class Ex_2_4_21 {

  static final class Stack<Key extends Comparable<Key>> {

    _MaxPQ pq = new _MaxPQ();
    int priority = 0;

    public Stack() {

    }

    public void push(Key t) {
      IKey key = new IKey();
      key.value = t;
      key.priority = this.priority++;
      pq.insert(key);
    }

    public Key pop() {
      IKey key = (IKey) pq.delMax();
      return key.value;
    }

    public boolean isEmpty() {
      return pq.isEmpty();
    }

    class IKey implements Comparable<IKey> {

      Key value;
      int priority;

      @Override
      public int compareTo(IKey another) {
        return compare(this.priority, another.priority);
      }

      public int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
      }
    }

  }


  static final class Queue<Key extends Comparable<Key>> {

    _MaxPQ pq = new _MaxPQ();
    int priority = Integer.MAX_VALUE;

    public void enqueue(Key v) {
      IKey k = new IKey();
      k.value = v;
      k.priority = priority--;
      pq.insert(k);
    }

    public Key dequeue() {
      if (!pq.isEmpty()) {
        IKey key = (IKey) pq.delMax();
        return key.value;
      } else {
        return null;
      }
    }

    public Key peek() {
      IKey key = (IKey) pq.delMax();
      pq.insert(key);
      return key.value;
    }

    public boolean isEmpty() {
      return pq.isEmpty();
    }


    class IKey implements Comparable<IKey> {

      Key value;
      int priority;

      @Override
      public int compareTo(IKey another) {
        return compare(this.priority, another.priority);
      }

      public int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
      }
    }
  }

  static final class RandomizedQueue<Key extends Comparable<Key>> {

    _MaxPQ pq = new _MaxPQ();
    HashSet numSet = new HashSet();

    public void enqueue(Key v) {
      IKey k = new IKey();
      k.value = v;
      k.priority = random();
      pq.insert(k);
    }

    public Key dequeue() {
      if (!pq.isEmpty()) {
        IKey key = (IKey) pq.delMax();
        return key.value;
      } else {
        return null;
      }
    }

    public Key peek() {
      IKey key = (IKey) pq.delMax();
      pq.insert(key);
      return key.value;
    }

    public boolean isEmpty() {
      return pq.isEmpty();
    }

    public int random() {
      int num = 0;
      while (!numSet.contains(num)) {
        num = StdRandom.uniform(1, Integer.MAX_VALUE);
        numSet.add(num);
        break;
      }
      return num;
    }


    class IKey implements Comparable<IKey> {
      Key value;
      int priority;

      @Override
      public int compareTo(IKey another) {
        return compare(this.priority, another.priority);
      }

      public int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
      }
    }
  }


  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    String[] arr = new String[5];
    arr[0] = "ADB";
    arr[1] = "111";
    arr[2] = "AD222B";
    arr[3] = "ADB444";
    arr[4] = "444444";

    for (int i = 0; i < arr.length; i++) {
      stack.push(arr[i]);
    }

    while (!stack.isEmpty()) {
      StdOut.printf("%10s\n", stack.pop());
    }
// 输出：
//    444444
//    ADB444
//    AD222B
//    111
//    ADB

    Queue<String> queue = new Queue<>();
    for (int i = 0; i < arr.length; i++) {
      queue.enqueue(arr[i]);
    }
    while (!queue.isEmpty()) {
      StdOut.printf("%10s\n", queue.dequeue());
    }
//    输出：
//    ADB
//    111
//    AD222B
//    ADB444
//    444444

    // 随机队列
    Integer[] ints = ascIntArray(100);
    RandomizedQueue<Integer> rdmQ = new RandomizedQueue<>();
    for (int i = 0; i < ints.length; i++) {
      rdmQ.enqueue(ints[i]);
    }
    while (!rdmQ.isEmpty()) {
      StdOut.printf("%10s\n", rdmQ.dequeue());
    }
  }
}
