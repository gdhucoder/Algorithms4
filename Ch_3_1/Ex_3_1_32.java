package Ch_3_1;

import static tools.ArrayGenerator.*;

/**
 * Created by HuGuodong on 2018/11/25.
 */

public class Ex_3_1_32 {



  public static void main(String[] args) {
    int N = 10;
    Integer[] asc = ascIntArray(N);
    Integer[] desc = descIntArray(N);
    Integer[] allSame = intsToInteger(allSameInts(N, 1));
    Integer[] towKeyInts = intsToInteger(intsWithNkeys(N, 1, 2));
    _BinarySearchST<Integer, String> st = new _BinarySearchST<>();

    for(Integer key : asc){
      st.put(key, "A");
    }
    for(Integer key : desc){
      st.put(key, "A");
    }
    for(Integer key : allSame){
      st.put(key, "A");
    }
    for(Integer key : towKeyInts){
      st.put(key, "A");
    }
  }


}
