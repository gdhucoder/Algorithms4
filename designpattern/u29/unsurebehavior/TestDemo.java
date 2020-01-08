package designpattern.u29.unsurebehavior;

import static junit.framework.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * Created by HuGuodong on 1/8/20.
 */
public class TestDemo {

  @Test
  public void test() {

    Demo d = new Demo() {
      @Override
      public long getCurrentTimestamp() {
        Calendar c = Calendar.getInstance();
        c.set(2020, 1, 14);
        System.out.println(System.currentTimeMillis());
        System.out.println(c.getTimeInMillis());
        return c.getTimeInMillis();
      }
    };
    Calendar calendar = Calendar.getInstance();
    calendar.set(2020, 1, 1);
    Date dueTime = calendar.getTime();
    long days = d.calculateDelayDays(dueTime);
    assertEquals(days, 13L);
  }
}
