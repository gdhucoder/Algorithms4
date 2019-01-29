package Ch_5_1;


/**
 * Created by HuGuodong on 2019/1/27.
 */

public class _Alphabet {

  /**
   * the binary alphabet {0, 1}
   */
  public static final _Alphabet BINARY = new _Alphabet("01");

  /**
   *  The lowercase alphabet { a, b, c, ..., z }.
   */
  public static final _Alphabet LOWERCASE = new _Alphabet("abcdefghijklmnopqrstuvwxyz");

  private char[] alphabet;
  private int[] inverse; // indices
  private final int R; // the radix of the alphabet

  /**
   * create a new alphabet from chars in s
   * @param s
   */
  public _Alphabet(String s){
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

  /**
   * convert index to corresponding alphabet char
   * @param index
   * @return
   */
  public char toChar(int index){
    return alphabet[index];
  }

  /**
   * convert c to an index between 0 and R-1
   * @param c
   * @return
   */
  public int toIndex(char c){
    return inverse[c];
  }


  /**
   * is c in the alphabet
   * @param c
   * @return
   */
  public boolean contains(char c){
    return inverse[c] != -1;
  }

  /**
   * radix number of characters in alphabet
   * @return
   */
  public int R(){
    return R;
  }


  /**
   * number of bits to represent a index
   * @return
   */
  public int lgR(){
    int lgR = 0;
    for (int t = R-1; t >=1 ; t/=2) {
      lgR++;
    }
    return lgR;

  }

  /**
   * convert s to base R integer
   * @param s
   * @return
   */
  public int[] toIndices(String s){
    char[] source = s.toCharArray();
    int[] target = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      target[i] = toIndex(source[i]);
    }
    return target;
  }


  /**
   * convert R-base integer to string over this alphabet
   * @param indices
   * @return
   */
  public String toChars(int[] indices){
    StringBuilder s = new StringBuilder(indices.length);
    for (int i = 0; i < indices.length; i++) {
      s.append(toChar(indices[i]));
    }
    return s.toString();
  }


  public static void main(String[] args) {
    _Alphabet a1 = new _Alphabet("ab");
    int[] encode1 = a1.toIndices("aaaaabbbbb");
    String decode1 = a1.toChars(encode1);
    System.out.println(decode1);
  }


}
