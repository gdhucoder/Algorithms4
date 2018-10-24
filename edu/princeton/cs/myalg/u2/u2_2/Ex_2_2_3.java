package edu.princeton.cs.myalg.u2.u2_2;

/**
 * Created by HuGuodong on 2018/8/15.
 */

public class Ex_2_2_3 {

//  size =  1, merge(a,  0,  0,  1) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  1, merge(a,  2,  2,  3) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  1, merge(a,  4,  4,  5) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  1, merge(a,  6,  6,  7) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  1, merge(a,  8,  8,  9) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  1, merge(a, 10, 10, 11) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  2, merge(a,  0,  1,  3) A	E	Q	S	U	Y	E	I	N	O	S	T
//  size =  2, merge(a,  4,  5,  7) A	E	Q	S	E	I	U	Y	N	O	S	T
//  size =  2, merge(a,  8,  9, 11) A	E	Q	S	E	I	U	Y	N	O	S	T
//  size =  4, merge(a,  0,  3,  7) A	E	E	I	Q	S	U	Y	N	O	S	T
//  size =  8, merge(a,  0,  7, 11) A	E	E	I	N	O	Q	S	S	T	U	Y
  public static void main(String[] args) {
    String[] a = args;
    MergeSortBU.sort(a);
    MergeSortBU.show(a);
  }

}
