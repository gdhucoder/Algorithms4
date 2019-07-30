package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/7/30.
 */

public class Ex_1_3_44 {

  public static class _Buffer {

    _Stack<Character> lstack;
    _Stack<Character> rstack;

    public _Buffer() {
      lstack = new _Stack<>();
      rstack = new _Stack<>();
    }

    public void insert(char c) {
      lstack.push(c);
    }

    public char delete() {
      if (!lstack.isEmpty()) {
        return (char) lstack.pop();
      } else {
        return '\0';
      }
    }

    public char cur() {
      if (lstack.isEmpty()) {
        return '\0';
      }
      return lstack.peek();
    }

    public void left(int k) {
      while (!lstack.isEmpty() && k-- > 0) {
        rstack.push(lstack.pop());
      }
    }

    public void right(int k) {
      while (!rstack.isEmpty() && k-- > 0) {
        lstack.push(rstack.pop());
      }
    }

    public int size() {
      return lstack.size() + rstack.size();
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer();
      for (char c : lstack) {
        sb.append(c);
      }
      sb = sb.reverse();
      sb.append('|');
      for (char c : rstack) {
        sb.append(c);
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    String str = "abcdfeg";
    char[] chars = str.toCharArray();
    _Buffer bf = new _Buffer();
    for (int i = 0; i < chars.length; i++) {
      bf.insert(chars[i]);
    }
    StdOut.println(bf);
    bf.left(2);
    StdOut.println(bf);
    bf.right(2);
    StdOut.println(bf);
    StdOut.println(bf.size());
    bf.right(100);
    StdOut.println("move right: " + bf);
    bf.left(100);
    StdOut.println("move left: " + bf);
//    abcdfeg|
//    abcdf|eg
//    abcdfeg|
//    7
//    move right: abcdfeg|
//    move left: |abcdfeg
  }
}
