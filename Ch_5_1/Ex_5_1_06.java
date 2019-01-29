package Ch_5_1;

import static Ch_5_1.Ex_5_1_04._Quick3String.*;

/**
 * Created by HuGuodong on 2019/1/30.
 */

public class Ex_5_1_06 {

  public static void main(String[] args) {
    String[] a = "now is the time for all good people to come to the aid of".split(" ");
    sort(a);
    show(a);

//    sort( 0, 13,  0): now	is	the	time	for	all	good	people	to	come	to	the	aid	of
//    sort( 0,  5,  0): is	aid	come	for	all	good	now	to	people	to	the	time	of	the
//    sort( 0,  4,  0): aid	come	for	all	good	is	now	to	people	to	the	time	of	the
//    sort( 0,  1,  1): aid	all	for	good	come	is	now	to	people	to	the	time	of	the
//    sort( 2,  4,  0): aid	all	for	good	come	is	now	to	people	to	the	time	of	the
//    sort( 7, 13,  0): aid	all	come	for	good	is	now	to	people	to	the	time	of	the
//    sort( 7,  8,  0): aid	all	come	for	good	is	now	people	of	to	the	time	to	the
//    sort( 9, 13,  1): aid	all	come	for	good	is	now	of	people	to	the	time	to	the
//    sort( 9, 11,  1): aid	all	come	for	good	is	now	of	people	the	time	the	to	to
//    sort( 9, 10,  2): aid	all	come	for	good	is	now	of	people	the	the	time	to	to
//    sort( 9, 10,  3): aid	all	come	for	good	is	now	of	people	the	the	time	to	to
//    sort(12, 13,  2): aid	all	come	for	good	is	now	of	people	the	the	time	to	to
  }

}
