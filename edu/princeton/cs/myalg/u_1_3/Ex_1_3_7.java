package edu.princeton.cs.myalg.u_1_3;


import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by HuGuodong on 2018/6/11.
 */

public class Ex_1_3_7 {

  public static void main(String[] args) {
    ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    StdOut.println(stack.peek());
    StdOut.println(stack.pop());
  }

}

class ResizingArrayStack<Item> implements Iterable<Item>{

  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty(){
    return N == 0;
  }

  public int size(){
    return N;
  }

  private void resize(int max){
    // mover stack to a new array of size max
    Item[] temp = (Item[]) new Object[max];
    for(int i=0; i<N; i++){
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item){
    // add item to top of stack
    if(N==a.length){
      resize(2*a.length);
    }
    a[N++] = item;
  }

  public Item pop(){
    // remove item from top of stack
    Item item = a[--N];
    a[N] = null;
    if(N>0 && N==a.length/4){
      resize(a.length/2);
    }
    return item;
  }

  public Item peek(){
    return a[N-1];
  }

  public int getArraySize(){
    return a.length;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item>{
    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public Item next() {
      return a[--i];
    }

    @Override
    public void forEachRemaining(Consumer<? super Item> action) {

    }
  }
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this) {
      s.append(item);
      s.append(' ');
    }
    return s.toString();
  }
}
