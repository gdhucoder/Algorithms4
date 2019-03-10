package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/11.
 */

public class _BinaryDump {

  public static void main(String[] args) {
    int width = Integer.parseInt(args[0]);
    int cnt;
    for(cnt=0;!BinaryStdIn.isEmpty(); cnt++){
      if(width==0) continue;
      if(cnt!=0 && cnt%width==0){
        StdOut.println();
      }
      if(BinaryStdIn.readBoolean()){
        StdOut.print("1");
      }else{
        StdOut.print("0");
      }
    }
    StdOut.println();
    StdOut.println(cnt+" bits.");

// cd 到class中 将文件放到资源中 程序默认会去找，不用绝对路径。
//    E:\gitspace\x1c\Alg4\algs4\target\classes>java Ch_5_5._BinaryDump 16 < abra.txt
//    0100000101000010
//    0101001001000001
//    0100001101000001
//    0100010001000001
//    0100001001010010
//    0100000100100001
//    96 bits.

  }
}
