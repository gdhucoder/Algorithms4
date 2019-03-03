package Ch_1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/3/3.
 */

public class Ex_1_1_21 {

  public static class Record{
    String name;
    int v1;
    int v2;
    public Record(String name, int v1, int v2){
      this.name = name;
      this.v1 = v1;
      this.v2 = v2;
    }

    @Override
    public String toString() {
      return "Record{" +
          "name='" + name + '\'' +
          ", v1=" + v1 +
          ", v2=" + v2 +
          '}';
    }
  }


  public static void main(String[] args) {
    while (!StdIn.isEmpty()){
      String line = StdIn.readLine();
      if("Q".equals(line)){
        return;
      }
      String[] rec = line.split(" ");
      Record r = new Record(rec[0], Integer.parseInt(rec[1]), Integer.parseInt(rec[2]));
      StdOut.printf("%10s, %d, %d, %.3f\n",r.name, r.v1, r.v2, (double)r.v1/r.v2);
    }
  }
}
