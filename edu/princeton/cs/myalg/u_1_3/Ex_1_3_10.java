package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Created by HuGuodong on 2018/6/25.
 */

public class Ex_1_3_10 {

  /**
   * 将中缀转换为后缀
   * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
   * 1 2 3 + 4 5 * * +
   * @param args
   */
  public static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\algs4\\src\\main\\java\\edu\\princeton\\cs\\myalg\\u_1_3\\input3_10.txt");
    System.setIn(fis);
    Stack<String> ops = new Stack<>();
    Stack<String> vals = new Stack<>();
    while (!StdIn.isEmpty()){
      String s = StdIn.readString();
      if(s.equals("(")){

      }else if(s.equals("+")
          || s.equals("-")
          || s.equals("*")
          || s.equals("/")){
        ops.push(s);
      }else if(s.equals(")")){
        String v = vals.pop();
        String op = ops.pop();
        v = String.format("%s %s %s",vals.pop(), v, op );
        vals.push(v);
      }else {
        vals.push(s);
      }
    }
    StdOut.println(vals.pop());
  }


}
