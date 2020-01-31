package designpattern.u39;

/**
 * Created by HuGuodong on 1/31/20.
 */
public class RequestStat {

  private double maxResponseTime;
  private double minResponseTime;
  private double avgResponseTime;
  private double p999ResponseTime;
  private double p99ResponseTime;
  private long count;
  private long tps;
  //...省略getter/setter方法...

  public RequestStat() {

  }

  public RequestStat(double maxResponseTime, double minResponseTime, double avgResponseTime,
      double p999ResponseTime, double p99ResponseTime, long count, long tps) {
    this.maxResponseTime = maxResponseTime;
    this.minResponseTime = minResponseTime;
    this.avgResponseTime = avgResponseTime;
    this.p999ResponseTime = p999ResponseTime;
    this.p99ResponseTime = p99ResponseTime;
    this.count = count;
    this.tps = tps;
  }

  public double getMaxResponseTime() {
    return maxResponseTime;
  }

  public void setMaxResponseTime(double maxResponseTime) {
    this.maxResponseTime = maxResponseTime;
  }

  public double getMinResponseTime() {
    return minResponseTime;
  }

  public void setMinResponseTime(double minResponseTime) {
    this.minResponseTime = minResponseTime;
  }

  public double getAvgResponseTime() {
    return avgResponseTime;
  }

  public void setAvgResponseTime(double avgResponseTime) {
    this.avgResponseTime = avgResponseTime;
  }

  public double getP999ResponseTime() {
    return p999ResponseTime;
  }

  public void setP999ResponseTime(double p999ResponseTime) {
    this.p999ResponseTime = p999ResponseTime;
  }

  public double getP99ResponseTime() {
    return p99ResponseTime;
  }

  public void setP99ResponseTime(double p99ResponseTime) {
    this.p99ResponseTime = p99ResponseTime;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public long getTps() {
    return tps;
  }

  public void setTps(long tps) {
    this.tps = tps;
  }
}