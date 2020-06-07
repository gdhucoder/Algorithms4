package ALeetCode.comp.p192;

import java.util.LinkedList;

/**
 * Created by HuGuodong on 12/8/19.
 */
public class Problem3 {

  static class BrowserHistory {

    LinkedList<String> que;
    int curPt = 0;

    public BrowserHistory(String homepage) {
      que = new LinkedList<>();
      que.addLast(homepage);
    }

    public void visit(String url) {
      System.out.println(que.size());
      System.out.println(que);
      while (que.size() > curPt + 1) {
        que.pollLast();
      }

      que.addLast(url);
      curPt++;
      System.out.println(que);
      System.out.println(curPt);
    }

    public String back(int steps) {

      curPt = curPt - steps;
      if (curPt < 0) curPt = 0;
      String res = que.get(curPt);
      System.out.println(res + ":" + curPt);
      return res;
    }

    public String forward(int steps) {
      curPt = curPt + steps;
      if (curPt >= que.size()) curPt = que.size() - 1;
      String res = que.get(curPt);
      System.out.println(res + ":" + curPt);
      return res;
    }
  }

  public static void main(String[] args) {
    System.out.println();
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
    browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
    browserHistory.visit("youtube.com");
    browserHistory.back(1); // facebook
    browserHistory.back(1); // google.com
    browserHistory.forward(1); // facebook.com
    browserHistory.visit("linkedin.com");
    browserHistory.back(2);
    browserHistory.back(7);
  }
}
