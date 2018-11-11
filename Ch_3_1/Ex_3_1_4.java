package Ch_3_1;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * Created by HuGuodong on 2018/11/11.
 */

public class Ex_3_1_4 {

  static class Time implements Comparable<Time> {

    private final int hour; // 0~23
    private final int min; // 0~59
    private final int sec; // 0~59
    private final String timeStr;

    private static final String REGEX = "^\\d{2}:\\d{2}:\\d{2}$";
    private static Pattern p = Pattern.compile(REGEX);
    private static DecimalFormat df = new DecimalFormat("00:00:00");

    public Time(String time) {

      if (!p.matcher(time).matches()) {
        throw new IllegalArgumentException("time format is wrong: " + time);
      }
      String[] timeArr = time.split(":");
      int hour = Integer.parseInt(timeArr[0]);
      int min = Integer.parseInt(timeArr[1]);
      int sec = Integer.parseInt(timeArr[2]);

      if (hour >= 0 && hour <= 23
          && min >= 0 && min <= 59
          && sec >= 0 && sec <= 59) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        timeStr = time;
      } else {
        throw new IllegalArgumentException("time format is wrong: " + time);
      }

    }


    @Override
    public boolean equals(Object other) {
      if (other == this) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (this.getClass() != other.getClass()) {
        return false;
      }
      Time that = (Time) other;
      return (this.hour == that.hour) && (this.min == that.min) && (this.sec == that.sec);
    }

    @Override
    public int compareTo(Time that) {
      if(this.hour > that.hour){
        return +1;
      }

      if(this.hour < that.hour){
        return -1;
      }

      if(this.min > that.min){
        return +1;
      }

      if(this.min < that.min){
        return -1;
      }

      if(this.sec > that.sec){
        return +1;
      }

      if(this.sec < that.sec){
        return -1;
      }

      return 0;
    }

    @Override
    public String toString() {
      return String.format("%02d:%02d:%02d", hour, min, sec);
    }
  }

  static class Event {

    private final String event;

    public Event(String event){
      this.event = event;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (this.getClass() != other.getClass()) {
        return false;
      }
      Event that = (Event) other;
      return this.event.equals(that.event);
    }

    @Override
    public String toString() {
      return this.event;
    }
  }

  public static void main(String[] args) {
    Time time = new Time("00:12:59");
    StdOut.println(time);
    time = new Time("00:00:00");
    StdOut.println(time);
    time = new Time("23:59:59");
    StdOut.println(time);
    time = new Time("23:59:60");
    StdOut.println(time);
  }

}
