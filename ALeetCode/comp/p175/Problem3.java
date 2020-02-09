package ALeetCode.comp.p175;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class TweetCounts {

    Map<String, TreeSet<Long>> map;

    public TweetCounts() {
      map = new HashMap<>();
    }

    int gen = 0;

    public void recordTweet(String tweetName, int time) {
      if (!map.containsKey(tweetName)) {
        map.put(tweetName, new TreeSet<Long>());
      }
      map.get(tweetName).add((long) time << 32 | gen++);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime,
        int endTime) {
      int va = 0;
      if (freq.equals("minute"))
        va = 60;
      if (freq.equals("hour"))
        va = 3600;
      if (freq.equals("day"))
        va = 86400;

      List<Integer> ret = new ArrayList<>();
      for (int i = 0; i < (endTime - startTime + va) / va; i++) {
        ret.add(0);
      }
      if (map.containsKey(tweetName)) {
        for (long h : map.get(tweetName).subSet((long) startTime << 32, (long) endTime + 1 << 32)) {
          h = h >>> 32;
          int ind = (int) ((h - startTime) / va);
          ret.set(ind, ret.get(ind) + 1);
        }
      }
      return ret;
    }
  }


  /**
   * Your TweetCounts object will be instantiated and called as such: TweetCounts obj = new
   * TweetCounts(); obj.recordTweet(tweetName,time); List<Integer> param_2 =
   * obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
   */
  public static void main(String[] args) {
    TweetCounts counts = new TweetCounts();
    counts.recordTweet("hello", 50);
    counts.recordTweet("hello", 60);
    counts.recordTweet("hello", 61);
    counts.recordTweet("hello", 30);
    counts.recordTweet("hello", 121);
    List<Integer> cnts = counts.getTweetCountsPerFrequency("minute", "hello", 0, 60);
    System.out.println(cnts);
  }
}
