package Ch_3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HuGuodong on 2018/11/22.
 */

public class Ex_3_1_26 {

  static class Dictionary implements Comparable<Dictionary>{
    private String word;
    private Integer time;
    Dictionary(String word, Integer time){
      this.word = word;
      this.time = time;
    }
    @Override
    public int compareTo(Dictionary other) {

      int cmpTimes = this.time - other.time;
      int cmpString = this.word.compareTo(other.word);

      if(cmpTimes == 0){
        return - cmpString;
      }else{
        return - cmpTimes;
      }


    }

    @Override
    public String toString() {
      return String.format("%20s : %3d", word, time);
    }
  }



  // java Ch_3_1.Ex_3_1_26 10 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
  public static void main(String[] args) {

    Stopwatch stopwatch = new Stopwatch();

    int minlen = Integer.parseInt(args[0]); // key-length cutoff
    _BinarySearchST<String, Integer> st = new _BinarySearchST<>(100);
    int words = 0;
    while (!StdIn.isEmpty()){
      String word = StdIn.readString();
      if(word.length() < minlen){
        continue;
      }
      words++;
      if(!st.contains(word)){ //
        st.put(word, 1); // containsCount
      }else{
        st.put(word, st.get(word) + 1); // containsCount + 3
      }
    }

    // find the key with the highest frequency count
    String max = "";
    st.put(max, 0); // put 1次

    Dictionary[] dictionaries = new Dictionary[st.size()];
    int i = 0;
//    for(String word : st.keys()){
////      if(st.get(word) > st.get(max)){ // get 2D 次
////        max = word;
////      }
//      dictionaries[i++] = (new Dictionary(word, st.get(word)));
////      StdOut.printf( "%20s, %3d\n", word,st.get(word)); //
//    }

    Arrays.sort(dictionaries);

    for(Dictionary pair : dictionaries){
      StdOut.println(pair);
    }

    StdOut.println("words " + words); //
    StdOut.println(stopwatch.elapsedTime());

  }
}
