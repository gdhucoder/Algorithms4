package edu.princeton.cs.myalg.u2.u2_1;

/**
 * Created by HuGuodong on 2018/7/9.
 */

public class Date implements Comparable<Date> {

  private final int day;
  private final int month;
  private final int year;

  public Date(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }

  @Override
  public int compareTo(Date o) {
    if(this.year > o.year) return 1;
    if(this.year <o.year) return -1;
    if(this.month > o.month) return 1;
    if(this.month < o.month) return -1;
    if(this.day > o.day) return 1;
    if(this.day < o.day) return -1;
    return 0;
  }

  public int day(){
    return day;
  }

  public int month(){
    return month;
  }

  public int year(){
    return year;
  }

  public String toString(){
    return month + "/" + day +"/"+year;
  }


}
