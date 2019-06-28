package Ch_1_1;

/**
 * Created by HuGuodong on 2019/4/12.
 */

import java.util.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
  /**
   * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
   **/


  public static int[] allNum; //
  public static int[] allNumRev; //

  public static int getIndex(int m) {
    allNum = new int[m + 1];
    for (int i = 0; i <= 3; i++) {
      allNum[i] = i + 1;
    }
    for (int i = 4; i <= m; i++) {
      allNum[i] = allNum[i - 2] + allNum[i - 3];
    }
    return allNum[m];
  }

  public static int getYear(int m) {
    int i;
    for (i = 0; i < allNum.length; i++) {
      if (allNum[i] > m) {
        break;
      }
    }
    return 2019 + i - 1 - 3;
  }

  public static int reverse(int num) {
    String strNum = "" + num;
    char[] strNumChar = strNum.toCharArray();
    String res = "";
    for (int i = strNumChar.length - 1; i >= 0; i--) {
      res += strNumChar[i];
    }
    return Integer.valueOf(res);
  }

  public static void reverAllIndex() {
    if (allNum != null) {
      allNumRev = new int[allNum.length];
      for (int i = 0; i < allNum.length; i++) {
        allNumRev[i] = reverse(allNum[i]);
      }
      Arrays.sort(allNumRev);
    }
  }

  public static int rank(int k) {
    reverAllIndex();
    int target = reverse(allNumRev[allNumRev.length - k]);
    for (int i = 0; i < allNum.length; i++) {
      if (allNum[i] == target) {
        return i;
      }
    }
    return -1;
  }


  static String calculate(int m, int k) {
    int index = getIndex(m); // 猪的序号
    int year = getYear(m);
    int rank = rank(k);
    return index + "," + year + "," + rank;

  }

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    String[] line = in.nextLine().split(",");
//    int m = Integer.valueOf(line[0]);
//    int k = Integer.valueOf(line[1]);;
    System.out.println(calculate(20, 3));

  }
}