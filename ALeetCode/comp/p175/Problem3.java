package ALeetCode.comp.p175;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class TweetCounts {

    private Map<String, PriorityQueue<Integer>> recordsMap;
    private Map<String, Integer> FREQ;

    public TweetCounts() {
      recordsMap = new HashMap();
      FREQ = new HashMap<>();
      FREQ.put("minute", 60);
      FREQ.put("hour", 60 * 60);
      FREQ.put("day", 60 * 60 * 24);
    }

    public void recordTweet(String tweetName, int time) {
      if (recordsMap.containsKey(tweetName)) {
        recordsMap.get(tweetName).add(time);
      } else {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.add(time);
        recordsMap.put(tweetName, que);
      }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq,
        String tweetName,
        int startTime,
        int endTime) {

      Map<Integer, Integer> result = new TreeMap<>();
      int delta = FREQ.get(freq);
      PriorityQueue<Integer> tweetsTime = recordsMap.get(tweetName);
      for (int time : tweetsTime) {
        if (time >= startTime && time <= endTime) {
          int idx = time / delta;
          if (result.containsKey(idx)) {
            result.put(idx, result.get(idx) + 1);
          }
        }
      }
      return Arrays.asList(result.values().toArray(new Integer[0]));
    }

  }

  public static void main(String[] args) {
    System.out.println();

  }
}
