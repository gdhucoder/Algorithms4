package Ch_5_1;

import static Ch_5_1.Ex_5_1_07._KeyIndexCounting.getInput;
import static Ch_5_1.Ex_5_1_07._KeyIndexCounting.sort;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2019/1/30.
 */

public class Ex_5_1_07 {

  public static class _KeyIndexCounting{
    
    public static void sort(_ItemKeyIndex[] a){
      
      int N = a.length;
      int R = 5;

      // a array of Queue Objects
      Queue<_ItemKeyIndex>[] aux  = new Queue[R];
      for (int i = 0; i < aux.length; i++) {
        aux[i] = new Queue();
      }

      // allocate objects according to keys
      for (int i = 0; i < N; i++) {
        aux[a[i].key()].enqueue(a[i]);
      }

      // distribute objects
      int count = 0;
      for (int r = 0; r < R; r++) {
        while (!aux[r].isEmpty()){
          a[count++] = aux[r].dequeue();
        }
      }

      // check
      assert count == a.length;
    }

    public static _ItemKeyIndex[] getInput(){
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

      return list.toArray(new _ItemKeyIndex[0]);
    }

  }


  public static void main(String[] args) {
    _ItemKeyIndex[] a = getInput();
    sort(a);
    StdOut.println("排序之后：");
    for (_ItemKeyIndex item: a ) {
      StdOut.println(item);
    }
//    排序之后：
//    _ItemKeyIndex{name='Harris', key=1}
//    _ItemKeyIndex{name='Martin', key=1}
//    _ItemKeyIndex{name='Moore', key=1}
//    _ItemKeyIndex{name='Anderson', key=2}
//    _ItemKeyIndex{name='Martinez', key=2}
//    _ItemKeyIndex{name='Miller', key=2}
//    _ItemKeyIndex{name='Robinson', key=2}
//    _ItemKeyIndex{name='White', key=2}
//    _ItemKeyIndex{name='Brown', key=3}
//    _ItemKeyIndex{name='Davis', key=3}
//    _ItemKeyIndex{name='Jackson', key=3}
//    _ItemKeyIndex{name='Jones', key=3}
//    _ItemKeyIndex{name='Taylor', key=3}
//    _ItemKeyIndex{name='Williams', key=3}
//    _ItemKeyIndex{name='Garcia', key=4}
//    _ItemKeyIndex{name='Johnson', key=4}
//    _ItemKeyIndex{name='Simth', key=4}
//    _ItemKeyIndex{name='Thomas', key=4}
//    _ItemKeyIndex{name='Thompson', key=4}
//    _ItemKeyIndex{name='Wilson', key=4}
//
  }
}
