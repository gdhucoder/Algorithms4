package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.util.Stack;

/**
 * Created by HuGuodong on 2018/6/6.
 */

public class Ex_1_3_4 {

  // [ ( ] )
  // [ ( ) ] { } [ { } ] ( )
  public static void main(String[] args) throws Exception {
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\algs4\\src\\main\\java\\edu\\princeton\\cs\\myalg\\u_1_3\\test.txt");
    System.setIn(fis);
    Stack<String> ops = new Stack<>();
    boolean flag = true;
    while(!StdIn.isEmpty()){
      String s = StdIn.readString();
      StdOut.print(s+" ");
      if(s.equals("[")){
        ops.push(s);
      }else if (s.equals("(")){
        ops.push((s));
      }else if (s.equals("{")){
        ops.push(s);
      }

      if((s.equals("]") && !ops.pop().equals("["))
          || (s.equals(")") && !ops.pop().equals("("))
          || (s.equals("}") && !ops.pop().equals("{"))){
          StdOut.println(false);
          flag = false;
          break;
      }
    }

    if(flag){
      StdOut.println(true);
    }

  }

}
