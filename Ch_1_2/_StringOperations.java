package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by HuGuodong on 2019/6/12.
 */

public class _StringOperations {

  /**
   * is the string a palindrome
   */
  public static boolean isPalindrome(String s) {
    int N = s.length();
    for (int i = 0; i < N / 2; i++) {
      if (s.charAt(i) != s.charAt(N - 1 - i)) {
        return false;
      }
    }
    return true;
  }


  @Test
  public void isPalindrome() {
    String s = "abcba";
    boolean isPal = isPalindrome(s);
    assert isPal == true;

    s = "abccba";
    isPal = isPalindrome(s);
    assert isPal == true;

    s = "abca";
    isPal = isPalindrome(s);
    assert isPal == false;
  }

  public static void extractFileName(String fileName) {
    int dot = fileName.indexOf(".");
    String base = fileName.substring(0, dot);
    String extension = fileName.substring(dot + 1, fileName.length());
    StdOut.printf("base: %s, extension: %s", base, extension);
  }

  @Test
  public void testExtractFileName() {
    String s = "驱蚊花露水.doc";
    extractFileName(s);
//    base: 驱蚊花露水, extension: doc
  }

  /**
   * check wether a string array is in alphabetical order
   */
  public static boolean isSorted(String[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i - 1].compareTo(a[i]) > 0) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void isSorted() {
    String[] a = {"b", "a"};
    assert isSorted(a) == false;
    String[] b = {"a", "ab", "abc"};
    assert isSorted(b) == true;
  }

}
