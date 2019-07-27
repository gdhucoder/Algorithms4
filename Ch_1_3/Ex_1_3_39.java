package Ch_1_3;

/**
 * Created by HuGuodong on 2019/7/27.
 */

public class Ex_1_3_39 {

  public static class RingBuffer<Item> {

    Item[] a;
    int first;
    int last;
    final int size;
    int N;

    public RingBuffer(int cap) {
      Item[] a = (Item[]) new Object[cap];
      size = cap;
    }

    public boolean isFull() {
      return N == size;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public Item dequeue() {
      if (isEmpty()) {
        throw new IllegalArgumentException("queue is empty");
      }
      Item item = a[first];
      a[first] = null;
      first = first++ % a.length;
      N--;
      return item;
    }

    public void enqueue(Item item) {
      if (isFull()) {
        throw new IllegalArgumentException("queue is full");
      }
      a[last++] = item;
      if (last == a.length) {
        last = 0;
      }
      N++;
    }
  }
}
