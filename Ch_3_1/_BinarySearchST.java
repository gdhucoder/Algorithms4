package Ch_3_1;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/11/5.
 */

public class _BinarySearchST<Key extends Comparable<Key>, Value> {

  private Key[] keys;
  private Value[] vals;
  private int N;

  public _BinarySearchST(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    vals = (Value[]) new Object[capacity];
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
  }

  public void delete(Key key) {

    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0) { // 如果key存在
      for (int j = N; j > i; j--) {
        keys[j - 1] = keys[j];
        vals[j - 1] = vals[j];
      }
      N--;
    }

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
    return get(key) !=null;
  }


  public Key min() {
    if(isEmpty()){
      throw new IllegalStateException("ST is empty!");
    }
    return keys[0];
  }

  public Key max() {
    if(isEmpty()){
      throw new IllegalStateException("ST is empty!");
    }
    return keys[N - 1];
  }

  public Key select(int k) {
    if(k<0 || k>size()){
      throw new IllegalArgumentException(k+" must between 0 and size of ST!");
    }
    return keys[k];
  }

  /**
   * smallest key(celling) >= given key()
   * e.g. 1 3 5 7
   * key = 4
   * celling(4) = 5
   * @param key
   * @return
   */
  public Key ceiling(Key key) {
    if(isEmpty()){
      throw new IllegalStateException("ST is empty!");
    }
    int i = rank(key);
    return keys[i];
  }

  /**
   * largest key (floor) <= given key
   * e.g. 1 3 5 7
   * key = 4
   * floor(4) = 3
   * @param key
   * @return
   */
  public Key floor(Key key) {

    if(isEmpty()){
      throw new IllegalStateException("ST is empty!");
    }

    int i = rank(key);
    if(i<N && keys[i].compareTo(key) == 0){ // key in ST
      return keys[i];
    }else if(i>0 && i<N && keys[i].compareTo(key) > 0){
      return keys[i-1]; // the last element
    }else if(i==N){
      return keys[i-1];
    }else{ // i == 0
      return null;
    }
  }

  /**
   * Returns the number of keys in this symbol table in the specified range
   * @param lo minimum endpoint
   * @param hi maximum endpoint
   * @return the number of keys in this symbol table between {@code lo}
   *         (inclusive) and {@code hi}(inclusive)
   */
  public int size(Key lo, Key hi){

    if(lo == null){
      throw new IllegalArgumentException("first argument to size() is null");
    }
    if(hi == null){
      throw new IllegalArgumentException("second argument to size() is null");
    }

    if(lo.compareTo(hi) > 0){
      return 0;
    }
    if(contains(hi)){
      return rank(hi) - rank(lo) + 1;
    }else{
      return rank(hi) - rank(lo);
    }
  }


  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < N; i++) {
      sb.append("{" + keys[i].toString() + ": " + vals[i].toString() + "}\n");
    }

    return sb.toString();
  }

  public static void main(String[] args) {

    String[] arr = "A C E H L M P R S X".split(" ");
    int n = arr.length;
    _BinarySearchST<Integer, String> st = new _BinarySearchST(n);
    for (int i = 0; i < n; i++) {
      st.put(i, arr[i]);
    }

    StdOut.println(st);
    StdOut.println("size: " + st.size());

    StdOut.println("max key is: " + st.max());

    StdOut.println("min key is:  " + st.min());

    // 删除最大的key
    st.deleteMax();
    StdOut.println(st);

    // 删除最小的key
    st.deleteMin();
    StdOut.println(st);

    StdOut.println(st.select(2));

    // 更行key, value
    st.put(8, "New Value");
    StdOut.println("new value " + st.get(8)); // 输出 New Value

    //

    StdOut.println("size: " + st.size());
    StdOut.println(st);

    StdOut.println(st.floor(9));
  }
}
