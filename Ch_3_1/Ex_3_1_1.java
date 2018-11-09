package Ch_3_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/9.
 */

public class Ex_3_1_1 {

  public static void main(String[] args) {
    _BinarySearchST<String, Double> st = new _BinarySearchST<>(100);

    // 初始化 gpa 对应的分数
    while (!StdIn.isEmpty()){
      String[] gpaMapping = StdIn.readLine().split(" ");
      st.put(gpaMapping[0], Double.parseDouble(gpaMapping[1]));
    }

    StdOut.println(st);

    String[] arr = "A+ A A- B+ B B- C+ C C- D F".split(" ");
//    String[] arr = "A+ A+ A+".split(" "); // 4.330

    // get sum scores
    double sum = 0.0;
    for(String key:arr){
      sum += st.get(key);
    }
    // average score
    double avg = sum / arr.length;

    StdOut.printf("Average GPA is : %.3f", avg);


//    {A: 4.0}
//    {A+: 4.33}
//    {A-: 3.67}
//    {B: 3.0}
//    {B+: 3.33}
//    {B-: 3.67}
//    {C: 2.0}
//    {C+: 3.33}
//    {C-: 1.67}
//    {D: 1.0}
//    {F: 0.0}
//
//    Average GPA is : 2.727

  }

}
