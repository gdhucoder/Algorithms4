package Ch_2_4;

/**
 * Created by HuGuodong on 2019/5/29.
 */

public class Ex_2_4_33 {

  public static class IndexMinPQ<Key extends Comparable<Key>> {

    private int N; // number of elements on PQ
    private int maxN;
    private int[] pq; // binary heap using 1-based indexing
    private int[] qp; // inverse: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // items with priorities

    public IndexMinPQ(int maxN) {
      keys = (Key[]) new Comparable[maxN + 1];
      this.maxN = maxN;
      pq = new int[maxN + 1];
      qp = new int[maxN + 1];
      for (int i = 0; i <= maxN; i++) {
        pq[i] = -1;
      }
    }

    /**
     * insert item, associate it with k
     */
    public void insert(int k, Key key) {
      if (k < 0 || N > maxN) {
        throw new IllegalStateException("k is less than 0 or pq is full");
      }
      N++;
      pq[N] = k;
      qp[k] = N;
      keys[k] = key;
      swim(N);
    }

    private void swim(int k){
      while (k >1 && greater(k/2, k)){
        exch(k, k/2);
        k = k / 2;
      }
    }

    private boolean greater(int i, int j){
      return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j){
      int swap = pq[i];
      pq[i] = pq[j];
      pq[j] = swap;
      qp[pq[i]] = i;
      qp[pq[j]] = j;
    }



    /**
     * change the item associated with k to item
     */
    public void change(int k, Key key) {

    }

    /**
     * remove k and its associated item
     */
    public void delete(int k) {

    }

    /**
     * remove minimum item and item's index
     */
    public int delMin() {
      return 0;
    }

    /**
     * is k associated with some item?
     */
    public boolean contains(int k) {
      return pq[k] != -1;
    }


    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    public Key min() {
      if (!isEmpty()) {
        return keys[pq[1]];
      }
      return null;
    }

    /**
     * return a minimal item's index
     */
    public int minIndex() {
      if (!isEmpty()) {
        return qp[pq[1]];
      }
      return 0;
    }

  }

  public static void main(String[] args) {
    String[] strings = {"Z", "B", "A"};
    IndexMinPQ pq = new IndexMinPQ(strings.length);
    for (int i = 0; i < strings.length; i++) {
      pq.insert(i, strings[i]);
    }
  }
}
