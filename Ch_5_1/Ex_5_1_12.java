package Ch_5_1;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2019/2/19.
 */

public class Ex_5_1_12 {
//  5.1.12 Alphabet. Develop an implementation of the Alphabet API that is given on page 698 and use it to develop LSD and MSD sorts for general alphabets.


  public static class Alphabet {

    /**
     * The binary alphabet { 0, 1 }.
     */
    public static final Alphabet BINARY = new Alphabet("01");

    /**
     * The octal alphabet { 0, 1, 2, 3, 4, 5, 6, 7 }.
     */
    public static final Alphabet OCTAL = new Alphabet("01234567");

    /**
     * The decimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }.
     */
    public static final Alphabet DECIMAL = new Alphabet("0123456789");

    /**
     * The hexadecimal alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F }.
     */
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");

    /**
     * The DNA alphabet { A, C, T, G }.
     */
    public static final Alphabet DNA = new Alphabet("ACGT");

    /**
     * The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    /**
     * The uppercase alphabet { A, B, C, ..., Z }.
     */

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     * The protein alphabet { A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W, Y }.
     */
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    /**
     * The base-64 alphabet (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet(
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     * The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    /**
     * The extended ASCII alphabet (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    /**
     * The Unicode 16 alphabet (0-65,535).
     */
    public static final Alphabet UNICODE16 = new Alphabet(65536);


    private char[] alphabet; // the characters in the alphabet
    private int[] inverse; // indices
    private final int R; // the radix of the alphabet

    public Alphabet(String s) {
      boolean[] unicode = new boolean[Character.MAX_VALUE];
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (unicode[c]) {
          throw new
              IllegalArgumentException
              ("Illegal alphabet: repeated character = '" + c + "'");
        }
      }

      alphabet = s.toCharArray();
      R = s.length();
      inverse = new int[Character.MAX_VALUE];
      for (int i = 0; i < inverse.length; i++) {
        inverse[i] = -1;
      }

      for (int c = 0; c < R; c++) {
        inverse[alphabet[c]] = c;
      }

    }

    private Alphabet(int radix) {
      this.R = radix;
      alphabet = new char[R];
      inverse = new int[R];
      for (int i = 0; i < R; i++) {
        alphabet[i] = (char) i;
      }
      for (int i = 0; i < R; i++) {
        inverse[i] = i;
      }
    }

    public Alphabet() {
      this(256);
    }

    public boolean contains(char c) {
      return inverse[c] != -1;
    }

    public int R() {
      return R;
    }

    public int lgR() {
      int lgR = 0;
      for (int t = R - 1; t >= 1; t = t >> 1) {
        lgR++;
      }
      return lgR;
    }

    public int toIndex(char c) {
      if (c >= inverse.length || inverse[c] == -1) {
        throw new IllegalArgumentException("Character " + c + " not in alphabet");
      }
      return inverse[c];
    }

    public int[] toIndices(String s) {
      char[] source = s.toCharArray();
      int[] target = new int[s.length()];
      for (int i = 0; i < source.length; i++) {
        target[i] = toIndex(source[i]);
      }
      return target;
    }

    public char toChar(int index) {
      if (index < 0 || index >= R) {
        throw new IllegalArgumentException("index must be between 0 and " + R + ": " + index);
      }
      return alphabet[index];
    }

    public String toChars(int[] indices) {
      StringBuilder s = new StringBuilder(indices.length);
      for (int i = 0; i < indices.length; i++) {
        s.append(toChar(indices[i]));
      }
      return s.toString();
    }


  }

  public static class LSD {

    private static int charAt(Alphabet alphabet, String s, int d) {
      if (d < s.length()) {
        return alphabet.toIndex(s.charAt(d));
      } else {
        return -1;
      }
    }

    public static void sort(Alphabet alphabet, String[] a, int w) {
      int N = a.length;
      int R = alphabet.R();
      String[] aux = new String[N];
      for (int d = w - 1; d >= 0; d--) {
        int[] count = new int[R + 1];
        for (int i = 0; i < N; i++) {
          count[charAt(alphabet, a[i], d) + 1]++;
        }
        for (int r = 0; r < R; r++) {
          count[r + 1] += count[r];
        }
        for (int i = 0; i < N; i++) {
          aux[count[charAt(alphabet, a[i], d)]++] = a[i];
        }
        for (int i = 0; i < N; i++) {
          a[i] = aux[i];
        }
      }
    }
  }

  public static class MSD {

    private static String[] aux;
    private static int R;

    private static int charAt(Alphabet alphabet, String s, int d) {
      if (d < s.length()) {
        return alphabet.toIndex(s.charAt(d));
      } else {
        return -1;
      }
    }

    public static void sort(Alphabet alphabet, String[] a) {
      int N = a.length;
      aux = new String[N];
      R = alphabet.R();
      sort(alphabet, a, 0, N-1, 0);
    }

    private static void sort(Alphabet alphabet, String[] a, int lo, int hi, int d) {
      if(hi<=lo){
        return;
      }
      int[] count = new int[R + 2];
      for (int i = lo; i <= hi; i++) {
        count[charAt(alphabet, a[i], d) + 2]++;
      }
      for (int r = 0; r < R + 1; r++) {
        count[r + 1] += count[r];
      }
      for (int i = lo; i <= hi; i++) {
        aux[count[charAt(alphabet, a[i], d) + 1]++] = a[i];
      }
      for (int i = lo; i <= hi; i++) {
        a[i] = aux[i - lo];
      }
      for (int r = 0; r < R; r++) {
        sort(alphabet, a, lo+count[r], lo+count[r+1]-1, d+1);
      }
    }
  }

  @Test
  public void testAlphabet() {
    int[] encoded1 = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
    String decoded1 = Alphabet.BASE64.toChars(encoded1);
    StdOut.println(decoded1);

    int[] encoded2 = Alphabet.DNA.toIndices("AACGAACGGTTTACCCCG");
    String decoded2 = Alphabet.DNA.toChars(encoded2);
    StdOut.println(decoded2);

    int[] encoded3 = Alphabet.DECIMAL.toIndices("01234567890123456789");
    String decoded3 = Alphabet.DECIMAL.toChars(encoded3);
    StdOut.println(decoded3);
  }

  public static void show(Object[] a) {
    for (Object o : a) {
      StdOut.print(o + "\t");
    }
    StdOut.println();
  }


  /**
   * 测试LSD
   */
  @Test
  public void testLSD(){
    String[] a = "no is th ti fo al go pe to co to th ai of th pa".split(" ");
    LSD.sort(Alphabet.LOWERCASE, a, 2);
    show(a);
  }


  /**
   * 测试MSD
   */
  @Test
  public void testMSD(){
    String s = "she, shells, seashells, by, the, sea, shore, the, shells, she, shells, are, surely, seashells";
    String[] a = s.replaceAll(" ", "").split(",");
    MSD.sort(Alphabet.LOWERCASE, a);
    show(a);
  }

  public static void main(String[] args) {


  }


}
