package Ch_5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.Picture;
import java.awt.Color;

/**
 * Created by HuGuodong on 2019/3/11.
 */

public class _PictureDump {

  /**
   * Reads in a sequence of bytes from standard input and draws them to standard drawing output as a
   * width-by-height picture, using black for 1 and white for 0 (and red for any leftover pixels).
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    int width = Integer.parseInt(args[0]);
    int height = Integer.parseInt(args[1]);
    Picture picture = new Picture(width, height);
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (!BinaryStdIn.isEmpty()) {
          boolean bit = BinaryStdIn.readBoolean();
          if (bit)
            picture.set(col, row, Color.BLACK);
          else
            picture.set(col, row, Color.WHITE);
        } else {
          picture.set(col, row, Color.RED);
        }
      }
    }
    picture.show();
  }
}
