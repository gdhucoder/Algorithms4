package tools;

import static tools.ArrayGenerator.*;

import org.junit.Test;

/**
 * Created by HuGuodong on 2018/11/12.
 */

public class TestArrayGenerator {


  @Test
  public void testIntegers(){
    show(Integers(10, 1,2));
  }




  @Test
  public void testAscIntArray(){
    Integer[] arr = ascIntArray(15,45);
    show(arr);
    arr = ascIntArray(30);
    show(arr);
    arr = descIntArray(16, 30);
    show(arr);
    arr = descIntArray(30);
    show(arr);
  }

}
