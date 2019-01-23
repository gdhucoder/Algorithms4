package Ch_5_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HuGuodong on 2018/11/25.
 */

public class Ex_5_1_01 {

  public static void main(String[] args) {
    ST<String, Integer> items = new ST<>();
    items.put("Anderson", 2);
    items.put("Brown", 3);
    items.put("Davis", 3);
    items.put("Garcia", 4);
    items.put("Harris", 1);
    items.put("Jackson", 3);
    items.put("Johnson", 4);
    items.put("Jones", 3);
    items.put("Martin", 1);
    items.put("Martinez", 2);
    items.put("Miller", 2);
    items.put("Moore", 1);
    items.put("Robinson", 2);
    items.put("Simth", 4);
    items.put("Taylor", 3);
    items.put("Thomas", 4);
    items.put("Thompson", 4);
    items.put("White", 2);
    items.put("Williams", 3);
    items.put("Wilson", 4);

    Set<Integer> keys = new HashSet<>();
    for(String key : items.keys()){
      keys.add(items.get(key));
    }
    int counts = keys.size();
    StdOut.println(counts);

    int N = items.size();
    int[] count = new int[counts+1];
    for(String key : items.keys()){
      count[items.get(key)+1]++;
    }
    for (int r = 0; r < counts; r++) {
      count[r+1] += count[r];
    }
    // 将元素分类
    StdOut.println(count);

  }

}
