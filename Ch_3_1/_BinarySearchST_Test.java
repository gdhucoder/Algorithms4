package Ch_3_1;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by HuGuodong on 2018/11/8.
 */

public class _BinarySearchST_Test {

  @Test
  public void testCeilingAndFloor() {
    String[] arr = "A C E H L M P R S X".split(" ");
    int n = arr.length;
    _BinarySearchST<Integer, String> st = new _BinarySearchST(n);
    for (int i = 0; i < n; i++) {
      st.put(2 * i + 1, arr[i]);
    }

//    {1: A}
//    {3: C}
//    {5: E}
//    {7: H}
//    {9: L}
//    {11: M}
//    {13: P}
//    {15: R}
//    {17: S}
//    {19: X}

    StdOut.println(st);
    StdOut.println("rank(5) is: " + st.rank(5)); // 2
    StdOut.println("ceiling(5) is: " + st.ceiling(5)); // 5
    StdOut.println("ceiling(4) is: " + st.ceiling(4)); // 5
    StdOut.println("floor(19) is: " + st.floor(19)); // 19
    StdOut.println("floor(20) is: " + st.floor(20)); // 19
    StdOut.println("floor(-1) is: " + st.floor(-1)); // null
    StdOut.println("floor(1) is: " + st.floor(1)); // 1
    StdOut.println("floor(4) is: " + st.floor(4)); // 3
    StdOut.println("floor(5) is: " + st.floor(5)); // 5


  }

  @Test
  public void testSize() {
    String[] arr = "A C E H L M P R S X".split(" ");
    int n = arr.length;
    _BinarySearchST<Integer, String> st = new _BinarySearchST(n);
    for (int i = 0; i < n; i++) {
      st.put(2 * i + 1, arr[i]);
    }

    //
    Assert.assertEquals(st.size(4, 8), 2);
    Assert.assertEquals(st.size(3, 8), 3);
    Assert.assertEquals(st.size(3, 7), 3);
    Assert.assertEquals("size() is wrong.",st.size(4, 7), 2);
  }
}
