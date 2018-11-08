package Ch_3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import tools.VisualAccumulator;

/**
 * Created by HuGuodong on 2018/11/5.
 */

public class _FrequencyCounter {

  // 显示曲线
  static VisualAccumulator visualAccumulator = new VisualAccumulator(14500, 6000);

//  cmd:
//  java Ch_3_1._FrequencyCounter 8 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
//  java Ch_3_1._FrequencyCounter 10 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\leipzig1M.txt

  public static void main(String[] args) {

    Stopwatch stopwatch = new Stopwatch();

    int minlen = Integer.parseInt(args[0]); // key-length cutoff
    _SequentialSearchST<String, Integer> st = new _SequentialSearchST<>();
    int words = 0;
    int distinct = 0;
    int accCount = 0;
    while (!StdIn.isEmpty()){
      String word = StdIn.readString();
      if(word.length() < minlen){
        continue;
      }
      words++;
      int containsCount = st.containsCounts(word);
      accCount+=containsCount;
//      if(!st.contains(word)){ // put W
      if(containsCount==distinct){ // put W
        st.put(word, 1);
        distinct++;
      }else{
        st.put(word, st.get(word) + 1); // get W-D
      }

      visualAccumulator.addDataValue(containsCount);
    }

    // find the key with the highest frequency count
    String max = "";
    st.put(max, 0); // put 1次
    for(String word : st.keys()){
      if(st.get(word) > st.get(max)){ // get 2D 次
        max = word;
      }
    }

    StdOut.println(max + " " + st.get(max)); // get 1 次
    StdOut.println("words " + words); //
    StdOut.println("distinct " + distinct);
    StdOut.println("accCount/N " + accCount/words);
    StdOut.println(stopwatch.elapsedTime());

  }

}
