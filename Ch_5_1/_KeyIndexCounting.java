package Ch_5_1;

import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2019/1/13.
 */

public class _KeyIndexCounting {

  public Object[] input(){
    List<_ItemKeyIndex> list = new ArrayList<>();

    list.add(new _ItemKeyIndex("Anderson", 2));
    list.add(new _ItemKeyIndex("Brown", 3));
    list.add(new _ItemKeyIndex("Davis", 3));
    list.add(new _ItemKeyIndex("Garcia", 4));
    list.add(new _ItemKeyIndex("Harris", 1));
    list.add(new _ItemKeyIndex("Jackson", 3));
    list.add(new _ItemKeyIndex("Johnson", 4));
    list.add(new _ItemKeyIndex("Jones", 3));
    list.add(new _ItemKeyIndex("Martin", 1));
    list.add(new _ItemKeyIndex("Martinez", 2));
    list.add(new _ItemKeyIndex("Miller", 2));
    list.add(new _ItemKeyIndex("Moore", 1));
    list.add(new _ItemKeyIndex("Robinson", 2));
    list.add(new _ItemKeyIndex("Simth", 4));
    list.add(new _ItemKeyIndex("Taylor", 3));
    list.add(new _ItemKeyIndex("Thomas", 4));
    list.add(new _ItemKeyIndex("Thompson", 4));
    list.add(new _ItemKeyIndex("White", 2));
    list.add(new _ItemKeyIndex("Williams", 3));
    list.add(new _ItemKeyIndex("Wilson", 4));



    return list.toArray();
  }

  public static void main(String[] args) {
    _KeyIndexCounting kic = new _KeyIndexCounting();
    Object[] ori = kic.input();
    _ItemKeyIndex[] a = new _ItemKeyIndex[ori.length];

    for (int i = 0; i < ori.length; i++) {
      a[i] = (_ItemKeyIndex) ori[i];
    }

    StdOut.println("排序之前：");
    for (_ItemKeyIndex item: a ) {
      StdOut.println(item);
    }

    int N = a.length;
    int R = 5;
    _ItemKeyIndex[] aux = new _ItemKeyIndex[N];
    int[] count = new int[R+1];

    // compute frequency counts
    for (int i = 0; i < N; i++) {
      count[a[i].key()+1]++;
    }

    // Transform counts to indices
    for (int r = 0; r < R; r++) {
      count[r+1] += count[r];
    }

    // Distribute the records
    for (int i = 0; i < N; i++) {
      aux[count[a[i].key()]++] = a[i];
    }

    for (int i = 0; i < N; i++) {
      a[i] = aux[i];
    }

    StdOut.println("排序之后：");
    for (_ItemKeyIndex item: a ) {
      StdOut.println(item);
    }

  }

}
