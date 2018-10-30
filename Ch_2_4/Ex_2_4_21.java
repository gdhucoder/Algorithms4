package Ch_2_4;

import static tools.ArrayGenerator.ascIntArray;

import Ch_2_4.Ex_2_4_19.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/24.
 */

public class Ex_2_4_21 {

  static final class Stack<Key extends Comparable<Key>>{

    MaxPQ pq = new MaxPQ(100);
    int priority = 0;

    public Stack(){

    }

    public void push(Key t){
      IKey key = new IKey();
      key.value = t;
      key.priority = this.priority++;
      pq.insert(key);
    }

    public Key pop(){
      IKey key = (IKey) pq.delMax();
      return key.value;
    }

    public boolean isEmpty(){
      return pq.isEmpty();
    }


    class IKey implements Comparable<IKey>{
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

    for(int i=0; i<arr.length; i++){
      stack.push(arr[i]);
    }

    while (!stack.isEmpty()){
      StdOut.printf("%10s\n", stack.pop());
    }
// 输出：
//    444444
//    ADB444
//    AD222B
//    111
//    ADB

  }

}
