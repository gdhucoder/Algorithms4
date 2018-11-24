package Ch_3_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/24.
 */

public class Ex_3_1_28 {

  static class _BinarySearchST<Key extends Comparable<Key>, Value> {

    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N;

    public _BinarySearchST() {
      keys = (Key[]) new Comparable[INIT_CAPACITY];
      vals = (Value[]) new Object[INIT_CAPACITY];
    }

    public _BinarySearchST(int capacity) {
      keys = (Key[]) new Comparable[capacity];
      vals = (Value[]) new Object[capacity];
    }

    private void resize(int newCapacity) {
      assert newCapacity >= N;
      Key[] tempK = (Key[]) new Comparable[newCapacity];
      Value[] tempV = (Value[]) new Object[newCapacity];
      for (int i = 0; i < N; i++) {
        tempK[i] = keys[i];
        tempV[i] = vals[i];
      }
      keys = tempK;
      vals = tempV;
    }


    public int size() {
      return N;
    }

    public Value get(Key key) {

      if (isEmpty()) {
        return null;
      }

      int i = rank(key);
      if (i < N && keys[i].compareTo(key) == 0) { // why do not use equals
        return vals[i];
      } else {
        return null;
      }

    }

    /**
     * 使用binary search可以急剧减少比较次数
     */
    public int rank(Key key) {
      int lo = 0;
      int hi = N - 1; // 元素一共有N-1个
      while (lo <= hi) { // lo <= hi ，我写成了lo < hi
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]); // 注意比較的順序 key 和 key[i] 比較
        if (cmp > 0) {
          lo = mid + 1;
        } else if (cmp < 0) {
          hi = mid - 1;
        } else {
          return mid;
        }
      }
      return lo; // 如果key不在symbol table中，返回比key小的keys的个数。
    }

    public void put(Key key, Value val) {

      if (val == null) {
        delete(key);
        return;
      }


      if (N == keys.length) {
        resize(2 * keys.length);
      }


      if(!isEmpty() &&
        key.compareTo(max())>=0){ // key is larger than all keys in the table
        keys[N] = key;
        vals[N] = val;
        N++;
      }

      int i = rank(key);
      if (i < N && keys[i].compareTo(key) == 0) { // 如果已经存在key，则更新value
        vals[i] = val;
        return;
      }


      for (int j = N; j > i; j--) {
        keys[j] = keys[j - 1];
        vals[j] = vals[j - 1];
      }
      keys[i] = key;
      vals[i] = val;
      N++;

      assert check();
    }

    public void delete(Key key) {

      if (key == null) {
        throw new IllegalArgumentException("key is null.");
      }

      if (isEmpty()) {
        return;
      }

      int i = rank(key);
      if (i == N || keys[i].compareTo(key) != 0) { // 如果key不存在
        return;
      }

      for (int j = N - 1; j > i; j--) {
        keys[j - 1] = keys[j];
        vals[j - 1] = vals[j];
      }
      N--;
      keys[N] = null; // to avoid loitering
      vals[N] = null;
      if (N > 0 && N == keys.length / 4) {
        resize(keys.length / 2);
      }

      assert check();

    }

    public void deleteMin() {
      if (isEmpty()) {
        return;
      }
      for (int i = 0; i < N - 1; i++) {
        keys[i] = keys[i + 1];
        vals[i] = vals[i + 1];
      }
      N--;
    }

    public void deleteMax() {
      if (isEmpty()) {
        return;
      }
      keys[N - 1] = null;
      vals[N - 1] = null;
      N--;
    }

    public boolean contains(Key key) {
      return get(key) != null;
    }


    public Key min() {
      if (isEmpty()) {
        throw new IllegalStateException("ST is empty!");
      }
      return keys[0];
    }

    public Key max() {
      if (isEmpty()) {
        throw new IllegalStateException("ST is empty!");
      }
      return keys[N - 1];
    }

    public Key select(int k) {
      if (k < 0 || k > size()) {
        throw new IllegalArgumentException(k + " must between 0 and size of ST!");
      }
      return keys[k];
    }

    /**
     * smallest key(celling) >= given key() e.g. 1 3 5 7 key = 4 celling(4) = 5
     */
    public Key ceiling(Key key) {
      if (isEmpty()) {
        throw new IllegalStateException("ST is empty!");
      }
      int i = rank(key);
      return keys[i];
    }

    /**
     * largest key (floor) <= given key e.g. 1 3 5 7 key = 4 floor(4) = 3
     */
    public Key floor(Key key) {

      if (isEmpty()) {
        throw new IllegalStateException("ST is empty!");
      }

      int i = rank(key);
      if (i < N && keys[i].compareTo(key) == 0) { // key in ST
        return keys[i];
      } else if (i > 0 && i < N && keys[i].compareTo(key) > 0) {
        return keys[i - 1]; // the last element
      } else if (i == N) {
        return keys[i - 1];
      } else { // i == 0
        return null;
      }
    }

    /**
     * Returns the number of keys in this symbol table in the specified range
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return the number of keys in this symbol table between {@code lo} (inclusive) and {@code
     * hi}(inclusive)
     */
    public int size(Key lo, Key hi) {

      if (lo == null) {
        throw new IllegalArgumentException("first argument to size() is null");
      }
      if (hi == null) {
        throw new IllegalArgumentException("second argument to size() is null");
      }

      if (lo.compareTo(hi) > 0) {
        return 0;
      }
      if (contains(hi)) {
        return rank(hi) - rank(lo) + 1;
      } else {
        return rank(hi) - rank(lo);
      }
    }


    public boolean isEmpty() {
      return N == 0;
    }

    public int containsCounts(Key key) {
      int lo = 0;
      int hi = N - 1; // 元素一共有N-1个
      int count = 0;
      while (lo <= hi) { // lo <= hi ，我写成了lo < hi
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]); // 注意比較的順序 key 和 key[i] 比較
        count++;
        if (cmp > 0) {
          lo = mid + 1;
        } else if (cmp < 0) {
          hi = mid - 1;
        } else {
          return count; // 注意返回比较次数
        }
      }
      return count;
    }

    public Iterable<Key> keys() {
      return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
      Queue<Key> que = new Queue<>();
      for (int i = rank(lo); i < rank(hi); i++) {
        que.enqueue(select(i));
      }
      if (contains(hi)) {
        que.enqueue(hi);
      }
      return que;
    }

    private boolean check() {
      return isSorted() && rankCheck();
    }

    /**
     * is all item in the array in ascending order
     */
    private boolean isSorted() {
      for (int i = 1; i < size(); i++) {
        if (keys[i].compareTo(keys[i - 1]) < 0) {
          return false;
        }
      }
      return true;
    }

    private boolean rankCheck() {
      for (int i = 0; i < size(); i++) {
        if (i != rank(select(i))) {
          return false;
        }
      }
      for (int i = 0; i < size(); i++) {
        if (keys[i] != select(rank(keys[i]))) {
          return false;
        }
      }
      return true;
    }

  }


  public static void main(String[] args) {

    String[] arr = "A C E H L M P R S X".split(" ");
    int n = arr.length;
    _BinarySearchST<Integer, String> st = new _BinarySearchST(n);
    for (int i = 0; i < n; i++) {
      st.put(i, arr[i]);
    }

    for(Integer key : st.keys()){
      StdOut.println(key + ":" + st.get(key));
    }

  }

}
