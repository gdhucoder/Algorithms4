package Ch_3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2018/11/13.
 */

public class Ex_3_1_09 {

//  cmd:
//  java Ch_3_1.Ex_3_1_09 1 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
//  java Ch_3_1.Ex_3_1_09 8 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
//  java Ch_3_1.Ex_3_1_09 10 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
  public static void main(String[] args) throws Exception{

    Integer[] length = {1, 8, 10};

    int minlen = 10;
      FileInputStream in =
          new FileInputStream("E:\\gitspace\\x1c\\Alg4\\algs4\\src\\main\\java\\Ch_3_1\\tale.txt");

      System.setIn(in);

      _SequentialSearchST<String, Integer> st = new _SequentialSearchST<>();
      int words = 0;
      String last = null;
      while (!StdIn.isEmpty()){
        String word = StdIn.readString();
        if(word.length() < minlen){
          continue;
        }
        words++;
        last = word; // 记录最后一次插入的单词
        if(!st.contains(word)){
          st.put(word, 1);
        }else{
          st.put(word, st.get(word) + 1);
        }

      }
      StdOut.println("cut-off : "+ minlen);
      StdOut.println("last word inserted is : "+ last);
      StdOut.println("words " + (words-1)); //

//    cut-off : 1
//    last word inserted is : known
//    count 135634
//
//    cut-off : 8
//    last word inserted is : faltering
//    words 14349
//
//    cut-off : 10
//    last word inserted is : disfigurement
//    words 4581
  }
}
