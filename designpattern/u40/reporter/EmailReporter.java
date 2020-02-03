package designpattern.u40.reporter;

import designpattern.u40.Aggregator;
import designpattern.u40.storage.MetricsStorage;
import designpattern.u40.viewer.StatViewer;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class EmailReporter extends Reporter {

  private static final Long DAY_HOURS_IN_SECONDS = 86400L;

  private ScheduledExecutorService executor;

  public EmailReporter(StatViewer viewer, Aggregator aggregator,
      MetricsStorage metricsStorage) {
    super(viewer, aggregator, metricsStorage);
  }


  public void startDailyReport() {
    Date firstTime = getNextDateTimeZero(new Date());
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
        long endTimeInMillis = System.currentTimeMillis();
        long startTimeInMillis = endTimeInMillis - durationInMillis;
        doReport(startTimeInMillis, endTimeInMillis);
      }
    }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
  }

  private Date getNextDateTimeZero(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
}