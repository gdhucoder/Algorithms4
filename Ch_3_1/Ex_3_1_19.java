package Ch_3_1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/13.
 */

public class Ex_3_1_19 {

  //  java Ch_3_1.Ex_3_1_19 8 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
  public static void main(String[] args) {

    _SequentialSearchST<String, Integer> st = new _SequentialSearchST<>();
    Queue<String> que = new Queue<>();

    String[] words = {
        "A", "A", "B", "B", "B", "A",
        "C", "C", "C", "D", "D", "E", "E",
        "E", "F"
    };

    for (String word : words) {
      st.put(word,
          st.contains(word) ?
              st.get(word) + 1 : 1);
    }

    // find the key with the highest frequency count
    String max = "";
    st.put(max, 0); // put 1次

    for (String word : st.keys()) {
      if (st.get(word) > st.get(max)) { // get 2D 次
        max = word;
      }
    }

    StdOut.println(max + " " + st.get(max)); // get 1 次

    for (String word : st.keys()) {
      if (st.get(word) == st.get(max)) { // 次数相等
        que.enqueue(word);
      }
    }

    while (!que.isEmpty()) {
      StdOut.println(que.dequeue());
    }

  }
}
