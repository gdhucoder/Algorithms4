package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.TST;

/**
 * The {@code _LZWCompression} class provides static methods for compressing and expanding a binary
 * input using LZW compression over the 8-bit extended ASCII alphabet with 12-bit codewords Created
 * by HuGuodong on 2019/4/4.
 */

public class _LZWCompression {

  private static final int R = 256;
  private static final int L = 4096; // number of codewords = 2^12
  private static final int W = 12;

  // Do not instantiate.
  private _LZWCompression() {}

  /**
   * Reads a sequence of 8-bit bytes from standard input; compresses them using LZW compression with
   * 12-bit code words and write the results to standard out put
   */
  public static void compress() {
    String input = BinaryStdIn.readString();
    TST<Integer> st = new TST<>();
    for (int i = 0; i < R; i++) {
      st.put("" + (char) i, i);
    }
    int code = R + 1; // R is code word for EOF
    while (input.length() > 0) {
      // Step 1 find the longest string s in the symbol table
      // that is the prefix of the unscanned input
      String s = st.longestPrefixOf(input); // Find max prefix match.

      // write 12 bit value
      BinaryStdOut.write(st.get(s), W); // Print s's encoding
      int t = s.length();
      if (t < input.length() && code < L) {
        // scan one character past s in the input ( t + 1)
        st.put(input.substring(0, t + 1), code++); // Add s to symbol table
      }
      input = input.substring(t); // scan past s in input
    }
    BinaryStdOut.write(R, W); // Write EOF
    BinaryStdOut.close();

//    Iterable<String> s = st.keys();
//    for(String ss : s){
//      System.err.println(ss+": "+ st.get(ss));
//    }
  }

  public static void expand() {

  }

  public static void main(String[] args) {
    if (args[0].equals("-"))
      compress();
    else if (args[0].equals("+"))
      expand();
    else
      throw new IllegalArgumentException("Illegal command line argument");
  }
}
