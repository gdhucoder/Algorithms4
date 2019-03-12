package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/12.
 */

public class _HexDump {

  private _HexDump() {}

  public static void main(String[] args) {
    int bytesPerLine = 16;
    if (args.length == 1) {
      bytesPerLine = Integer.parseInt(args[0]);
    }

    int i;
    for (i = 0; !BinaryStdIn.isEmpty(); i++) {
      if (bytesPerLine == 0) {
        BinaryStdIn.readChar();
        continue;
      }
      if (i == 0)
        StdOut.printf("");
      else if (i % bytesPerLine == 0)
        StdOut.printf("\n");
      else
        StdOut.print(" ");
      char c = BinaryStdIn.readChar();
      StdOut.printf("%02x", c & 0xff);
    }
    if (bytesPerLine != 0)
      StdOut.println();
    StdOut.println(i * 8 + " bits");
  }

}
