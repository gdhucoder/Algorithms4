package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by HuGuodong on 2019/2/22.
 */

public class _Counter {

  private final String name; // counter name
  private int count = 0; // current value

  /**
   * initializes a new counter starting at 0, with the given id.
   * @param id the name of the counter
   */
  public _Counter(String id) {
    this.name = id;
  }

  /**
   * increment the counter by one
   */
  public void increment() {
    count++;
  }

  /**
   * number of increments since creation
   */
  public int tally() {
    return count;
  }

  public String toString() {
    return name + " " + count;
  }


  /**
   * create n counters
   * increment trials counters at random and print results
   * @param args
   */
  public static void main(String[] args) {
    int numCounters = 2;
    int trials = 10000;

    // create n counters
    _Counter[] hits = new _Counter[numCounters];
    for (int i = 0; i < numCounters; i++) {
      hits[i] = new _Counter("counter " + i);
    }

    // increment trials counters at random
    for (int i = 0; i < trials; i++) {
      hits[StdRandom.uniform(numCounters)].increment();
    }

    // print results
    for (int i = 0; i < numCounters; i++) {
      StdOut.println(hits[i]);
    }

  }


}
