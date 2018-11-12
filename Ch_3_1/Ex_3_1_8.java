package Ch_3_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/12.
 */

public class Ex_3_1_8 {


//  cmd:
//  java Ch_3_1.Ex_3_1_8 10 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
  public static void main(String[] args) {

    int minlen = Integer.parseInt(args[0]); // key-length cutoff
    _SequentialSearchST<String, Integer> st = new _SequentialSearchST<>();
    int words = 0;
    while (!StdIn.isEmpty()){
      String word = StdIn.readString();
      if(word.length() < minlen){
        continue;
      }
      words++;
      if(!st.contains(word)){
        st.put(word, 1);
      }else{
        st.put(word, st.get(word) + 1);
      }

    }

    // find the key with the highest frequency count
    String max = "";
    st.put(max, 0);
    for(String word : st.keys()){
      if(st.get(word) > st.get(max)){
        max = word;
      }
    }

    StdOut.println("the highest frequency word is: "+ max + ", " + st.get(max)+"times.");
    StdOut.println("words " + words); //

//    the highest frequency word is: monseigneur 101
//    words 4582

  }
}
