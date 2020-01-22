package designpattern.u35;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by HuGuodong on 1/22/20.
 */
public class TestIDGenerate {

  @Test
  public void testGenerateID() {
    IDGenerate gen = new IDGenerate();

    String id = gen.generate();
    String[] parts = id.split("-");

    String lastHostName = parts[0];
    String time = parts[1];
    String randChars = parts[2];

    // randChars length
    Assert.assertEquals(randChars.length(), 8);

    // randChars match A-Za-z\d length = 8
    Assert.assertTrue(randChars.matches("^[A-Za-z\\d]{8}$"));

    System.out.println(id);
  }
}
