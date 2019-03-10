package tools;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2018/10/28.
 */

public class Util {

  public static void show(Comparable[] a){
    for(int i=0; i<a.length; i++){
      StdOut.printf("%s  ", a);
    }
    StdOut.println();
  }



}
