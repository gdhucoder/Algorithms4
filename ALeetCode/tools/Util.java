package ALeetCode.tools;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuGuodong on 2020/5/31.
 */
public class Util {

  private Util() {}

  public static int[] readAnIntArray(String path) {
    String line = new In(path).readLine();
    //    System.out.println("line read: " + line);
    return parseAnIntArray(line);
  }

  public static List<int[]> readAllIntArray(String path) {
    In in = new In(path);
    List<int[]> res = new ArrayList<>();
    while (in.hasNextLine()) {
      res.add(parseAnIntArray(in.readLine()));
    }
    return res;
  }

  private static int[] parseAnIntArray(String line) {
    line = line.replaceAll("\\[", "").replaceAll("]", "");
    ;
    String[] numStr = line.split(",");
    int[] res = new int[numStr.length];
    for (int i = 0; i < numStr.length; i++) {
      res[i] = Integer.parseInt(numStr[i]);
    }
    //    System.out.print("ints array is: ");
    //    PrintUtil.show(numStr);
    return res;
  }

  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for (int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static String integerArrayToString(int[] nums, int length) {
    if (length == 0) {
      return "[]";
    }

    String result = "";
    for (int index = 0; index < length; index++) {
      int number = nums[index];
      result += Integer.toString(number) + ", ";
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayToString(int[] nums) {
    return integerArrayToString(nums, nums.length);
  }


  public static void main(String[] args) {
    String PATH = "ALeetCode/comp/prblemtemplates/in.txt";
    //    int[] a = readAnIntArray(PATH);
    List<int[]> allArray = readAllIntArray(PATH);
    System.out.println(allArray.size());
  }
}
