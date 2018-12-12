package Ch_4_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/12/11.
 */

public class _Topological {

  private Iterable<Integer> order; //topological order

  public _Topological(_Digraph G){
    _DirectedCycle cycleFinder = new _DirectedCycle(G);
    if(!cycleFinder.hasCycle()){
      _DepthFirstOrder dfs = new _DepthFirstOrder(G);
      order = dfs.reversePost();
    }
  }

  public Iterable<Integer> order(){
    return order;
  }

  public boolean isDAG(){
    return order == null;
  }

  public static void main(String[] args) {
    String filename = "jobs.txt";
    String delim = "/";
    _SymbolDigraph sg = new _SymbolDigraph(filename, delim);

    _Topological top = new _Topological(sg.G());
    for(int v : top.order())
      StdOut.println(sg.name(v));

  //
  //    Calculus
  //    Linear Algebra
  //    Introduction to CS
  //    Advanced Programming
  //    Algorithms
  //    Theoretical CS
  //    Artificial Intelligence
  //    Robotics
  //    Machine Learning
  //    Neural Networks
  //    Databases
  //    Scientific Computing
  //    Computational Biology

  }

}
