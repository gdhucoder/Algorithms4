package edu.princeton.cs.myalg.u2.u2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 * Created by HuGuodong on 2018/10/13.
 */

public class MyTopM {

  public static void main(String[] args) {
    // Print the top M lines in the input stream.
    int M = Integer.parseInt(args[0]);
    MinPQ<Transaction> pq = new MinPQ<>(M+1);
    while(StdIn.hasNextLine()){
      // Create an entry from the next line and put on the PQ.
      pq.insert(new Transaction(StdIn.readLine()));
      if(pq.size()>M){
        pq.delMin();
      }
    } // Top M entries are on the PQ.

    // print entries on PQ in reverse order.
    Stack<Transaction> stack = new Stack<>();
    while (!pq.isEmpty()){
      stack.push(pq.delMin());
    }
    for(Transaction t:stack){
      StdOut.println(t);
    }

  }
//C:\Users\x1c>E:
//
//E:\>cd E:\GDUT\Dropbox\Alg4\algs4\target\classes
//
//E:\GDUT\Dropbox\Alg4\algs4\target\classes>java edu.princeton.cs.myalg.u2.u2_4.MyTopM 5 < tinyBatch.txt

//  Thompson    2/27/2000  4747.08
//  vonNeumann  2/12/1994  4732.35
//  vonNeumann  1/11/1999  4409.74
//  Hoare       8/18/1992  4381.21
//  vonNeumann  3/26/2002  4121.85


}
