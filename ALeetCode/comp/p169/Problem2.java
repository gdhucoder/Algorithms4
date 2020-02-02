package ALeetCode.comp.p169;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  static class Solution {

    public int minFlips(int a, int b, int c) {
      int res = 0;
      for (int i = 0; i < 9; i++) {
        int bit_c = c >> i & 1;
        int bit_a = a >> i & 1;
        int bit_b = b >> i & 1;
        if (bit_c == 0) {
          if (bit_a == 1)
            res += 1;
          if (bit_b == 1)
            res += 1;
        } else {
          if (bit_a == 0 && bit_b == 0) {
            res += 1;
          }
        }

      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minFlips(1, 2, 3));
//    int a = 4;
//    for (int i = 0; i < 32; i++) {
//      System.out.println(a >> i & 1);
//    }
  }
}
