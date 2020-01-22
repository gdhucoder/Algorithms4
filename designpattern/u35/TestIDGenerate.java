package designpattern.u35;

import Ch_1_4._Stopwatch;
import java.util.Random;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by HuGuodong on 1/22/20.
 */
public class TestIDGenerate {

  @Test
  public void testGenerateID() {
    RandomLogTraceIDGenerator gen = new RandomLogTraceIDGenerator();

    String id = gen.generate();
    String[] parts = id.split("-");

    String lastHostName = parts[0];
    String time = parts[1];
    String randChars = parts[2];

    // randChars match A-Za-z\d length = 8
    Assert.assertTrue(randChars.matches("^[A-Za-z\\d]{8}$"));

    System.out.println(id);
  }

  @Test
  public void testNewRandom() {
    _Stopwatch stopwatch = new _Stopwatch();
    int NUM = 10000;
    for (int i = 0; i < NUM; i++) {
      Random r = new Random();
      System.out.println(r.nextInt(1000));
    }
    System.out.println(stopwatch.elapsedTime());
  }
}
