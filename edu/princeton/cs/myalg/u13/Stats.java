package edu.princeton.cs.myalg.u13;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileInputStream;

/**
 * Read a sequence of numbers from standard input and
 * compute their mean and standard deviation
 * Created by HuGuodong on 2018/5/8.
 */

public class Stats {
  public static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("E:\\GDUT\\Dropbox\\Alg4\\test_data\\stats.txt");
    System.setIn(fis);
    // read in numbers
    Bag<Double> numbers = new Bag<Double>();
    while (!StdIn.isEmpty()) {
      numbers.add(StdIn.readDouble());
    }
    int n = numbers.size();

    // compute sample mean
    double sum = 0.0;
    for (double x : numbers)
      sum += x;
    double mean = sum/n;

    // compute sample standard deviation
    sum = 0.0;
    for (double x : numbers) {
      sum += (x - mean) * (x - mean);
    }
    double stddev = Math.sqrt(sum/(n-1));

    StdOut.printf("Mean:    %.2f\n", mean);
    StdOut.printf("Std dev: %.2f\n", stddev);
  }
}
