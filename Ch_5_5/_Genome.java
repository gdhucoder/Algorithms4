package Ch_5_5;

import Ch_5_1._Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/12.
 */

public class _Genome {

  /**
   * compression method for genomic data
   */
  public static void compress() {
    _Alphabet DNA = new _Alphabet("ATCG");
    String s = BinaryStdIn.readString();
    int N = s.length();
    BinaryStdOut.write(N);
    for (int i = 0; i < N; i++) {
      int d = DNA.toIndex(s.charAt(i));
      BinaryStdOut.write(d, DNA.lgR());
    }
    BinaryStdOut.close();
  }

  /**
   * expansion method for genomic data
   */
  public static void expand() {
    _Alphabet DNA = new _Alphabet("ATCG");
    int w = DNA.lgR();
    int N = BinaryStdIn.readInt();
    for (int i = 0; i < N; i++) {
      int c = BinaryStdIn.readChar(w); // 读到的是 对应字符集的数字。
      BinaryStdOut.write(DNA.toChar(c));
    }
    BinaryStdOut.close();
  }

  public static void main(String[] args) {
    if (args[0].equals("-"))
      compress();
    if (args[0].equals("+"))
      expand();
  }
}
