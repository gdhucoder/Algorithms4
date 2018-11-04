package Ch_2_4;

import static tools.ArrayGenerator.ascIntArray;
import static tools.ArrayGenerator.randomIntArray;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/11/3.
 */

public class Ex_2_4_24 {

  static final class LinkedMaxPQ<Key extends Comparable<Key>>{
    Item root;
    Item last;
    int N;

    public void insert(Key v){
      Item item = new Item();
      item.v = v;
      Item prev;
      if(last==null){ // 开始堆为空 0 个结点
        root = item;
      }else if(root == last){ // 已经有1个结点
        root.left = item;
        item.parent = root;
      }else{
        prev = last.parent; // 最后一个结点的父节点
        if(prev.right==null){ // 非满二叉树，最后一个结点所在的右子树为空
          prev.right = item;
          item.parent = prev;
        }else{ // 最后一个结点所在的右子树已满
          while (prev!=root) { // 自底向上，沿着右子树回溯
            if (prev != prev.parent.right) {
              break;
            }
            prev = prev.parent;
          }
          if(prev!=root){ // 非满二叉树：prev为根节点的子树已满
            prev = prev.parent.right; // 沿着prev父结点右子树向左下走
          }else{ // 满二叉树
            prev = root; // 沿着结点左子树一路向下
          }
          while(prev.left!=null){
            prev = prev.left;
          }
          prev.left = item;
          item.parent = prev;
        }
      }
      N++;
      last = item;
      swim(item);
    }

    public Key delMax(){
      Key max = root.v;
      exch(root,last); // 根结点和最后一个结点交换
      if(N==1){ // 结点个数为1
        root = null;
        last = null;
      }else if(N==2){ // 结点个数为2
        root.left = null;
        last = root;
      }else{
        Item newLast = last;
        if(newLast == newLast.parent.right){ // 删除一个结点后，右子树为空，左子树为last结点
          newLast = last.parent.left;
        }else{
          while (newLast!=root){
            if(newLast == newLast.parent.right){
              break;
            }
            newLast = newLast.parent;
          }
          if(newLast==root){ // 删除一个结点后，为满二叉树
          }else{
            newLast = newLast.parent.left; // 删除一个结点后，为非满二叉树
          }
          while(newLast.right!=null){
            newLast = newLast.right;
          }
        }

        // 删除最后一个结点
        if(last.parent.right!=null){
          last.parent.right = null;
        }else if(last.parent.left!=null){
          last.parent.left = null;
        }
        // 更新最后一个结点
        last = newLast;
        // 下沉到正确的位置
        sink(root);
      }
      N--;

      return max;
    }

    private void swim(Item v){
      while (v.parent!=null && less(v.parent, v)){
        exch(v, v.parent);
        v = v.parent;
      }
    }

    private void sink(Item v){
      Item toExch = null;
      while (v.left!=null || v.right!=null){
        if(v.left!=null && v.right!=null){ // v存在左右结点
          if(less(v.left, v.right)){
            toExch = v.right;
          }else{
            toExch = v.left;
          }
        }else if(v.left!=null){ // 只有一个结点
          toExch = v.left;
        }else{
          toExch = v.right;
        }
        if(!less(v,toExch)) break;
        exch(v, toExch);
        // sink(toExch) // 使用递归也可以
        v = toExch;
      }
    }

    private void exch(Item a, Item b){
      Key swap = a.v;
      a.v = b.v;
      b.v = swap;
    }



    private boolean less(Item a, Item b){
      return a.v.compareTo(b.v) < 0;
    }

    public int size(){
      return N;
    }

    public boolean isEmpty(){
      return N==0;
    }

    public void show(){
      show(root);
    }

    public void show(Item item){
      if(item==null) return;
      if(item.left==null && item.parent==null) {
        return;
      }
      StdOut.println(item.v.toString());
      show(item.left);
      show(item.right);
    }

    public class Item{
      Key v;
      Item parent;
      Item left;
      Item right;

      @Override
      public String toString() {
        return "{"+v.toString()+"}";
      }
    }
  }


  public static void main(String[] args) {
    Integer[] a = randomIntArray(1,10);
    LinkedMaxPQ pq = new LinkedMaxPQ();
    for(int i=0; i<a.length; i++){
      pq.insert(a[i]);
    }
    pq.show();
    StdOut.println("====================================");
    for(int i=0; i<a.length; i++){
      StdOut.println(pq.delMax());
    }
  }

//10
//9
//8
//7
//6
//5
//4
//3
//2
//1


}
