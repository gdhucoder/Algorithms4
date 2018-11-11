package Ch_3_1;

import Ch_3_1.Ex_3_1_4.Event;
import Ch_3_1.Ex_3_1_4.Time;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/11/9.
 */

public class Ex_3_1_3 {

  static class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

    Node first;
    int n;

    public void put(Key key, Value val) {

      if (key == null) {
        throw new IllegalArgumentException("key is null");
      }

      if (val == null) {
        delete(key);
      }

      if (first == null) {
        first = new Node(key, val, null);
        n++;
        return;
      }
      Node x = first;
      for (; x.next != null; x = x.next) {
        if (x.key.compareTo(key) == 0) {
          x.val = val;
          return;
        }
      }

      // insert new node
      x.next = new Node(key, val, null);
      n++;
    }

    // value paired with key (null if key is absent)
    public Value get(Key key) {
      for (Node x = first; x != null; x = x.next) {
        if (x.key.compareTo(key) == 0) {
          return x.val;
        }
      }
      return null;
    }

    public void delete(Key key) {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      if (size() == 1 && first.key.compareTo(key) == 0) {
        first = null;
        n--;
      } else {
        Node prev = first;
        Node current = first.next;
        while (current != null) {
          if (current.key.compareTo(key) == 0) {
            prev.next = prev.next.next; // delete node
//            current.key = null;
//            current.val = null;
//            current.next = null;
            n--;
            return;
          }
          prev = prev.next;
          current = current.next;
        }


      }

    }

    public boolean contains(Key key) {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      return get(key) != null;
    }

    public int size() {
      return n;
    }

    public Key min() {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      return first.key;
    }

    public Key max() {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      Node x = first;
      while (x.next != null) {
        x = x.next;
      }
      return x.key;
    }

    // largest key less than or equal to key
    public Key floor(Key key) {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }

      Node x = first;
      while (x.next != null) {
        if (x.next.key.compareTo(key) > 0) {
          return x.key;
        }
        x = x.next;
      }

      return x.key;
    }

    // smallest key greater than or equal to key
    public Key ceiling(Key key) {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      Node x = first;
      while (x != null && x.key.compareTo(key) < 0) {
        x = x.next;
      }
      return x.key;
    }

    // number of keys less than key
    public int rank(Key key) {
      int i = 0;
      Node x = first;
      while (x != null) {
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
          i++;
        } else {
          if (cmp > 0) {
            break;
          }
        }
        x = x.next;
      }
      return i;
    }

    //key of rank k
    public Key select(int k) {
      if (k < 0 || k >= size()) {
        throw new IllegalArgumentException("called select() with invalid argument: " + k);
      }

      Node x = first;
      for (int i = 1; i <= k; i++) {
        x = x.next;
      }

      // rank 0 = first
      // rank 1 = first.next
      // rank 2 = first.next.next

      return x.key;

    }

    public void deleteMin() {

      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }

      Node x = first;
      first = first.next;
      x.next = null;
      x.key = null;
      x.val = null;
      n--;
    }

    public void deleteMax() {

      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }

      if (size() == 1) {
        first = null;
      } else {
        Node prev = first;
        Node current = prev.next;
        while (current.next != null) {
          current = current.next;
          prev = prev.next;
        }
        prev.next = null;
        n--;
      }
    }

    public int size(Key lo, Key hi) {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      if (lo.compareTo(hi) >= 0) {
        return 0;
      }

      int i = rank(hi) - rank(lo);
      if (hi.compareTo(select(rank(hi))) == 0) {
        i++;
      }

      return i;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      Queue<Key> que = new Queue<>();
      Node x = first;
      while (x != null) {
        if (x.key.compareTo(lo) >= 0 && x.key.compareTo(hi) <= 0) {
          que.enqueue(x.key);
        }
        x = x.next;
      }
      return que;
    }


    public Iterable<Key> keys() {
      if (isEmpty()) {
        throw new NoSuchElementException("ST underflow error");
      }
      Queue<Key> que = new Queue<>();
      Node x = first;
      while (x != null) {
        que.enqueue(x.key);
        x = x.next;
      }
      return que;
    }

    public boolean isEmpty() {
      return n == 0;
    }

    @Override
    public String toString() {
      Queue<Key> que = new Queue<>();
      StringBuffer sb = new StringBuffer();
      Node x = first;
      while (x != null) {
        sb.append(x.toString() + "\n");
        x = x.next;
      }
      return sb.toString();
    }

    private class Node {

      Key key;
      Value val;
      Node next;

      Node(Key key, Value val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
      }

      @Override
      public String toString() {
        return String.format("{%10s: %10s}", key.toString(), val.toString());
      }
    }

    /**
     * Test: OrderedSequentialSearchST
     */
    @Test
    public void testOrderedSequentialST() {
      OrderedSequentialSearchST<Time, Event> st = new OrderedSequentialSearchST<>();

      st.put(new Time("09:00:00"), new Event("Chicago"));
      st.put(new Time("09:00:03"), new Event("Phoenix"));
      st.put(new Time("09:00:13"), new Event("Houston"));
      st.put(new Time("09:00:59"), new Event("Chicago"));
      st.put(new Time("09:01:10"), new Event("Houston"));
      st.put(new Time("09:03:13"), new Event("Chicago"));
      st.put(new Time("09:10:11"), new Event("Seattle"));
      st.put(new Time("09:10:25"), new Event("Seattle"));
      st.put(new Time("09:14:25"), new Event("Phoenix"));
      st.put(new Time("09:19:32"), new Event("Chicago"));
      st.put(new Time("09:19:46"), new Event("Chicago"));
      st.put(new Time("09:21:05"), new Event("Chicago"));
      st.put(new Time("09:22:43"), new Event("Seattle"));
      st.put(new Time("09:22:54"), new Event("Seattle"));
      st.put(new Time("09:25:52"), new Event("Chicago"));
      st.put(new Time("09:35:21"), new Event("Chicago"));
      st.put(new Time("09:36:14"), new Event("Seattle"));
      st.put(new Time("09:37:44"), new Event("Phoenix"));

      // =================================================================================

      Assert.assertEquals(st.min(), new Time("09:00:00"));

      Assert.assertEquals(st.max(), new Time("09:37:44"));

      Assert.assertEquals(st.ceiling(new Time("09:30:00")), new Time("09:35:21"));

      Assert.assertEquals(st.ceiling(new Time("09:35:21")), new Time("09:35:21"));

      Assert.assertEquals(st.get(new Time("09:00:13")), new Event("Houston"));

      Assert.assertEquals(st.select(7), new Time("09:10:25"));

      Assert.assertEquals(st.floor(new Time("09:05:00")), new Time("09:03:13"));

      Assert.assertEquals(st.floor(new Time("09:01:10")), new Time("09:01:10"));

      Assert.assertEquals(st.rank(new Time("09:10:25")), 7);

      Assert.assertEquals(st.size(new Time("09:15:00"), new Time("09:25:00")), 5);

      StdOut.println("keys(09:15:00, 09:25:00) is:"
          + st.keys(new Time("09:15:00"), new Time("09:25:00"))); // 5

      st.deleteMax();

      Assert.assertEquals(st.max(), new Time("09:36:14"));

      st.deleteMin();

      Assert.assertEquals(st.max(), new Time("09:00:03"));

      StdOut.println(st);

      int n = st.size();
      while (!st.isEmpty()) {
        Time key = st.select(--n);
        StdOut.println(key);
        st.delete(key);
      }

      Assert.assertTrue(st.isEmpty());

//      st.delete(new Time("09:00:00"));
//      st.delete(new Time("09:00:13"));

      StdOut.println("finally: " + st.size());
    }

    public static void main(String[] args) {

      OrderedSequentialSearchST<Time, Event> st = new OrderedSequentialSearchST<>();

      st.put(new Time("09:00:00"), new Event("Chicago"));
      st.put(new Time("09:00:03"), new Event("Phoenix"));
      st.put(new Time("09:00:13"), new Event("Houston"));
      st.put(new Time("09:00:59"), new Event("Chicago"));
      st.put(new Time("09:01:10"), new Event("Houston"));
      st.put(new Time("09:03:13"), new Event("Chicago"));
      st.put(new Time("09:10:11"), new Event("Seattle"));
      st.put(new Time("09:10:25"), new Event("Seattle"));
      st.put(new Time("09:14:25"), new Event("Phoenix"));
      st.put(new Time("09:19:32"), new Event("Chicago"));
      st.put(new Time("09:19:46"), new Event("Chicago"));
      st.put(new Time("09:21:05"), new Event("Chicago"));
      st.put(new Time("09:22:43"), new Event("Seattle"));
      st.put(new Time("09:22:54"), new Event("Seattle"));
      st.put(new Time("09:25:52"), new Event("Chicago"));
      st.put(new Time("09:35:21"), new Event("Chicago"));
      st.put(new Time("09:36:14"), new Event("Seattle"));
      st.put(new Time("09:37:44"), new Event("Phoenix"));

      StdOut.println("min: " + st.min()); //09:00:00
      StdOut.println("max: " + st.max()); //09:37:44
      StdOut.println("ceiling(09:30:00): " + st.ceiling(new Time("09:30:00"))); //09:35:21
      StdOut.println("ceiling(09:35:21): " + st.ceiling(new Time("09:35:21"))); //09:35:21
      StdOut.println("get(09:00:13): " + st.get(new Time("09:00:13"))); //Houston
      StdOut.println("select(7) 09:10:25: " + st.select(7)); // 09:10:25
      StdOut.println("floor(09:05:00): " + st.floor(new Time("09:05:00"))); //09:03:13
      StdOut.println("floor(09:01:10): " + st.floor(new Time("09:01:10"))); //09:01:10
      StdOut.println("rank(09:10:25):" + st.rank(new Time("09:10:25"))); // 7
      StdOut.println("size(09:15:00, 09:25:00) is:"
          + st.size(new Time("09:15:00"), new Time("09:25:00"))); // 5
      StdOut.println("keys(09:15:00, 09:25:00) is:"
          + st.keys(new Time("09:15:00"), new Time("09:25:00"))); // 5

      st.deleteMax();
      st.deleteMin();
      StdOut.println(st);

      int n = st.size();
      while (!st.isEmpty()) {
        Time key = st.select(--n);
        StdOut.println(key);
        st.delete(key);
      }

//      st.delete(new Time("09:00:00"));
//      st.delete(new Time("09:00:13"));

      StdOut.println("finally: " + st.size());


    }


  }


}
