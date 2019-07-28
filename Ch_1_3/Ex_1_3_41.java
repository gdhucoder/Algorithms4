package Ch_1_3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import tools.PrintUtil;

/**
 * Created by HuGuodong on 2019/7/28.
 */

public class Ex_1_3_41 {

  public static class _Queue<Item> implements Iterable<Item> {

    public _Queue(_Queue<Item> another) {
      if (!another.isEmpty()) {
        for (Item item : another) {
          // this.enqueue(item);
          try {
            this.enqueue((Item) item.getClass().getDeclaredMethod("clone", null).invoke(item));
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            this.enqueue(item);
          }

        }
      }
    }

    public _Queue() {

    }

    private Node first; // link to the least added node
    private Node last; // link to hte most added node
    private int N;

    private class Node {

      Item item;
      Node next;
    }

    public void enqueue(Item item) {
      Node oldlast = last;
      last = new Node();
      last.item = item;
      last.next = null;
      if (isEmpty()) {
        first = last;
      } else {
        oldlast.next = last;
      }
      N++;
    }

    public Item dequeue() {
      Item item = first.item;
      first = first.next;
      if (isEmpty()) {
        last = null;
      }
      N--;
      return item;
    }

    public int size() {
      return N;
    }

    public boolean isEmpty() {
      return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
      return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

      private Node current = first;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public Item next() {
        Item item = current.item;
        current = current.next;
        return item;
      }
    }
  }

  public static class Student implements Cloneable {

    String name;

    public Student(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Student{" +
          "name='" + name + '\'' +
          '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      Student other = new Student(this.name);
      return other;
    }
  }


  public static void main(String[] args) {
    _Queue<Student> q = new _Queue<>();

    Student st_1 = new Student("st_1");
    Student st_2 = new Student("st_2");
    Student st_3 = new Student("st_3");
    Student st_4 = new Student("st_4");
    q.enqueue(st_1);
    q.enqueue(st_2);
    q.enqueue(st_3);
    q.enqueue(st_4);

    _Queue<Student> r = new _Queue<>(q);
    Student st_5 = new Student("st_5");
    r.enqueue(st_5);
    q.dequeue();
    st_4.name = "modify"; // modify st_4, but this operation does not effect element in the new queue.
    PrintUtil.show(q);
    PrintUtil.show(r);
//    Student{name='st_2'} Student{name='st_3'} Student{name='modify'}
//    Student{name='st_1'} Student{name='st_2'} Student{name='st_3'} Student{name='st_4'} Student{name='st_5'}
  }

}
