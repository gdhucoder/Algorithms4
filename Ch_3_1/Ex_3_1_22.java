package Ch_3_1;

import Ch_3_1.Ex_3_1_2.ArrayST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/20.
 */

public class Ex_3_1_22 {

  static class ArrayST<Key extends Comparable<Key>, Value> {

    Item<Key, Value>[] items;
    int N;

    private class Item<Key, Value> {

      Key key;
      Value value;

      Item(Key key, Value val) {
        this.key = key;
        this.value = val;
      }

      @Override
      public String toString() {
        return String.format("{%s: %s}", key.toString(), value.toString());
      }
    }

    public ArrayST() {

    }

    public ArrayST(int capacity) {
      items = new Item[capacity];
    }

    public void put(Key key, Value val) {

      if (val == null) {
        delete(key);
      }
      // 检查是否在第一个位置
      Item<Key, Value> first = items[0];

      if (isEmpty()) {
        items[0] = new Item<>(key, val);
        N++;
        return;
      }

      if (!isEmpty() && key.compareTo(first.key) == 0) {
        first.value = val;
        return;
      }

      // 如果key在ST中
      int i = 1;
      for (; i < N; i++) {
        if (key.compareTo(items[i].key) == 0) {
          move(items[i], i); // move to first
          items[0].value = val;
          return;
        }
      }
      if (i == N) {
        items[i] = new Item<>(key, val);
        N++;
      }

    }

    public Value get(Key key) {

      // 检查是否在第一个位置
      Item<Key, Value> first = items[0];
      if (key.compareTo(first.key) == 0) {
        return first.value;
      }

      // 顺序搜索
      for (int i = 1; i < N; i++) {
        if (key.compareTo(items[i].key) == 0) {
          move(items[i], i);
          return items[0].value; // first element
        }
      }
      return null;
    }

    private void move(Item<Key, Value> item, int pos) {
      Item<Key, Value> temp = items[0];
      items[0] = item;
      for (int i = pos; i > 1; i--) {
        items[i] = items[i - 1];
      }
      items[1] = temp;
    }

//    /**
//     * 效率不高 时间复杂度N^2
//     * @param key
//     */
//    public void delete(Key key) {
//      int i = 0;
//      for (; i < N - 1; i++) {
//
//        if (key.compareTo(keys[i]) == 0) { // 在ST中
//          for(int j=i; j<N-1; j++){
//            keys[j] = keys[j + 1];
//            vals[j] = vals[j + 1];
//          }
//          N--;
//          return;
//        }
//      }
//      if (i == N-1) { // the last element
//        keys[i] = null;
//        vals[i] = null;
//        N--;
//      }
//    }

    /**
     * 时间复杂度N
     */
    public void delete(Key key) {
      if (key == null) {
        return;
      }

      for (int i = 0; i < N; i++) {
        if (key.compareTo(items[i].key) == 0) {
          items[i] = items[N - 1];
          items[--N] = null;
          return;
        }
      }

    }

    public boolean contains(Key key) {
      return get(key) != null;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public int size() {
      return N;
    }

    public Iterable keys() {
      Queue<Key> que = new Queue<>();
      for (Item<Key, Value> item : items) {
        que.enqueue(item.key);
      }
      return que;
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < N; i++) {
        sb.append(items[i].toString() + "\n");
      }

      return sb.toString();
    }

    public void showFirst() {
      StdOut.println(items[0]);
    }

  }

  public static void main(String[] args) {
    ArrayST<Integer, String> st = new ArrayST(20);
    String[] arr = "A C E H L M P R S X".split(" ");
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      st.put(i, arr[i]);
    }

    for (int i = n - 1; i > 0; i--) {
      StdOut.println(st.get(i));
      st.showFirst();
    }

    for (int i = n - 1; i > 0; i--) {
      st.put(i, arr[i]);
      st.showFirst();
    }


  }
}
