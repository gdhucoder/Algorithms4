package Ch_3_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用无序数组实现符号表
 * put, delete
 * Created by HuGuodong on 2018/11/9.
 */

public class Ex_3_1_2 {

  static class ArrayST<Key extends Comparable<Key>, Value> {
    Item<Key, Value>[] items;
    int N;

    private class Item<Key, Value>{
      Key key;
      Value value;
      Item(Key key, Value val){
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

      if(val==null){
        delete(key);
      }

      // 如果key在ST中
      int i = 0;
      for (; i < N; i++) {
        if (key.compareTo(items[i].key) == 0) {
          items[i].value = val;
          return;
        }
      }
      if(i==N){
        items[i] = new Item<>(key, val);
        N++;
      }

    }

    public Value get(Key key) {

      for (int i = 0; i < N; i++) {
        if (key.compareTo(items[i].key) == 0) {
          return items[i].value;
        }
      }
      return null;
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
     * @param key
     */
    public void delete(Key key){
      if(key == null ){
        return;
      }

      for (int i = 0; i < N; i++) {
        if (key.compareTo(items[i].key) == 0) {
          items[i] = items[N-1];
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
      for (Item<Key,Value> item : items) {
        que.enqueue(item.key);
      }
      return que;
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < N; i++) {
        sb.append(items[i].toString()+"\n");
      }

      return sb.toString();
    }

  }

  public static void main(String[] args) {
    ArrayST<Integer, String> st = new ArrayST(20);
    String[] arr = "A C E H L M P R S X".split(" ");
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      st.put(i, arr[i]);
    }
    StdOut.println(st);
    st.delete(9);
    StdOut.println(st);
    StdOut.println(st.contains(9)); // false
    StdOut.println(st.size()); // 9
    StdOut.println(st.get(9)); // null
    st.put(8, "new value"); // new value
    StdOut.println(st.get(8)); // new value
    StdOut.println(st); //

    st.delete(2);
    StdOut.println(st);
//    {0: A}
//    {1: C}
//    {2: E}
//    {3: H}
//    {4: L}
//    {5: M}
//    {6: P}
//    {7: R}
//    {8: S}
//    {9: X}
//
//    {0: A}
//    {1: C}
//    {2: E}
//    {3: H}
//    {4: L}
//    {5: M}
//    {6: P}
//    {7: R}
//    {8: S}
//
//    false
//    9
//    null
//    new value
//    {0: A}
//    {1: C}
//    {2: E}
//    {3: H}
//    {4: L}
//    {5: M}
//    {6: P}
//    {7: R}
//    {8: new value}
//
//    {0: A}
//    {1: C}
//    {8: new value}
//    {3: H}
//    {4: L}
//    {5: M}
//    {6: P}
//    {7: R}

  }

}
