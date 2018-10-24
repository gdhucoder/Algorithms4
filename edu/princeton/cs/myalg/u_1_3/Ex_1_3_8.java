package edu.princeton.cs.myalg.u_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;
import java.util.Stack;

/**
 * Created by HuGuodong on 2018/6/11.
 */

public class Ex_1_3_8 {

  // it was - the best - of times - - - it was - the - -
  // 直接简单的就可以算出来：
  // 甚至不用运行代码：最后就剩一个it，一个元素 N=1， 数组大小为N的两倍， 所以数组的大小为2
  public static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\algs4\\src\\main\\java\\edu\\princeton\\cs\\myalg\\u_1_3\\intput3_8.txt");
    System.setIn(fis);
    ResizingArrayStack<String> stack = new ResizingArrayStack<>();
    while (!StdIn.isEmpty()){
      String s = StdIn.readString();
      if(s.equals("-")){
        stack.pop();
      }else{
        stack.push(s);

      }
    }

    StdOut.println("stack contents: " + stack);
    StdOut.println("stack array size: "+ stack.getArraySize());

  }
}
