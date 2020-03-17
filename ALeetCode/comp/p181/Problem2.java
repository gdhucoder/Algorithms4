package ALeetCode.comp.p181;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem2 {

  class CustomStack {

    int[] elements;
    int pos;
    int MAX;

    public CustomStack(int maxSize) {
      elements = new int[maxSize];
      MAX = maxSize;
    }

    public void push(int x) {
      if (pos == MAX) return;
      elements[pos++] = x;
    }

    public int pop() {
      if (pos == 0) return -1;
      return elements[--pos];
    }


    public void increment(int k, int val) {
      for (int i = 0; i < Math.min(k, pos); i++) {
        elements[i] += val;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println();
  }
}
