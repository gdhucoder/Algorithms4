package ALeetCode.comp.p162;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2019/11/10.
 */
public class Game03 {

  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    List<Integer> head = new ArrayList();
    List<Integer> tail = new ArrayList();
    List<List<Integer>> re = new ArrayList();
    int count = 0, cnt = 0;
    for (int i = 0; i < colsum.length; i++) {
      count += colsum[i];
      if (colsum[i] == 2) {
        cnt++;
      }
    }
    if (count != upper + lower || cnt > upper || cnt > lower)
      re = new ArrayList();
    else {
      int[] a = new int[colsum.length];
      int[] b = new int[colsum.length];
      for (int i = 0; i < colsum.length; i++) {
        a[i] = -1;
        b[i] = -1;
      }
      int up = 0, low = 0;
      for (int i = 0; i < colsum.length; i++) {
        if (colsum[i] == 0) {
          a[i] = 0;
          b[i] = 0;
        }
        if (colsum[i] == 2) {
          a[i] = 1;
          b[i] = 1;
          up++;
          low++;
        }
      }
      up = upper - up;
      low = lower - low;
      for (int i = 0; i < colsum.length; i++) {
        if (up != 0 && a[i] == -1) {
          a[i] = 1;
          b[i] = 0;
          up--;
        }
        if (low != 0 && b[i] == -1) {
          a[i] = 0;
          b[i] = 1;
          low--;
        }
      }
      for (int i = 0; i < colsum.length; i++) {
        head.add(a[i]);
        tail.add(b[i]);
      }
      re.add(head);
      re.add(tail);
    }
    return re;
  }

  public static void main(String[] args) {
    Game03 g = new Game03();
//    int[] cols = {2,0,2,1,1,2,2,0,1,1,1,0,0,0,0,2,1,2,2,2,1,1,0,0,0,0,1,2,1,0,1,0,2,0,0,0,0,2,1,1,2,1,1,0,0,1,0,0,1,1,2,0,1,1,1,2,1,0,0,1,1,1,2,2,1,0,0,1,1,1,0,2,1,2,1,0,1,2,0,2,2,1,0,1,1,1,2,0,0,0,1,2,2,0,0,1,1,2,1,2};
    int[] cols = {2, 1, 2, 2, 1, 1, 1};
//    4
//    7
//        [2,1,2,2,1,1,1]

//    5
//    5
//        [2,1,2,0,1,0,1,2,0,1]
    System.out.println("result: ");
    System.out.println("ans :" + g.reconstructMatrix(4, 7, cols));
    System.out.println(1);
  }
}
