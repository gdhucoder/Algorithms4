package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/2/18.
 */

public class Ex_1_3_18 {


  static class LinkedList<Item> {

    private Node first;
    private int N; // size;


    public void insertAtFirst(Item item) {
      Node oldfirst = first;
      first = new Node();
      first.item = item;
      first.next = oldfirst;
      N++;
    }

    public Item remove(Item item) {

      if(item == first.item){
        first = first.next;
        N--;
        return item;
      }else{
        Node x = first.next;
        for (; x != null; x = x.next) {
          if (x.next !=null && x.next.item == item) {

            // 删除结点
            x.next = x.next.next;
            N--;
            return item;
          }
        }
      }
      return null;
    }

    public int size(){
      return N;
    }


    public void print() {
      for (Node x = first; x != null; x = x.next) {
        StdOut.printf(x.item.toString() + "\t");
      }
      StdOut.println();
    }

    private class Node {

      Item item;
      Node next;
    }
  }

  public static void main(String[] args) {

    LinkedList<Integer> l = new LinkedList<>();
    l.insertAtFirst(1);
    l.insertAtFirst(2);
    l.insertAtFirst(3);
    l.insertAtFirst(4);
    l.insertAtFirst(5);
    l.print();

    l.remove(2);
    l.remove(5);
    l.print();

    StdOut.println("size: " + l.size());
  }
}
