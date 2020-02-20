package designpattern.u47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HuGuodong on 2/19/20.
 */
public class ProtoTypeDesignPattern {

  public static void main(String[] args) throws CloneNotSupportedException {
    HashMap<String, SearchWord> currentKeyWords = new HashMap<>();
    List<SearchWord> searchWords = genFakeData(5);
    for (SearchWord word : searchWords) {
      currentKeyWords.put(word.getKeyWord(), word);
      System.out.println(word);
    }

    List<SearchWord> toBeUpdatedWords = genFakeData(6);
    HashMap<String, SearchWord> newKeyWords = new HashMap<>();
    for (SearchWord word : toBeUpdatedWords) {
      if (newKeyWords.containsKey(word.getKeyWord())) {
        SearchWord oldWord = newKeyWords.get(word.getKeyWord());
        oldWord.setTimes(word.getTimes());
        oldWord.setTmstamp(word.getTmstamp());
        //        System.out.println(oldWord);
        SearchWord newWord = (SearchWord) oldWord.clone();
        System.out.println(newWord);
        newKeyWords.put(word.getKeyWord(), newWord);
      }
      else {
        newKeyWords.put(word.getKeyWord(), word);
        System.out.println(word);
      }
    }
  }

  class Demo {

  }


  private static List<SearchWord> genFakeData(int num) {
    List<SearchWord> ret = new ArrayList<>(num);
    for (int i = 0; i < num; i++) {
      ret.add(new SearchWord("00" + i, i + (i & 1), (long) i + (i & 1)));
    }
    return ret;
  }
}

class SearchWord {

  private String keyWord;
  private int times;
  private long tmstamp;

  public SearchWord(String keyWord, int times, long tmstamp) {
    this.keyWord = keyWord;
    this.times = times;
    this.tmstamp = tmstamp;
  }

  public String getKeyWord() {
    return keyWord;
  }

  public int getTimes() {
    return times;
  }

  public long getTmstamp() {
    return tmstamp;
  }
  //
  //  @Override
  //  public String toString() {
  //    return "SearchWord{" + "keyWord='" + keyWord + '\'' + ", times=" + times + ", tmstamp="
  //        + tmstamp + '}';
  //  }

  public void setKeyWord(String keyWord) {
    this.keyWord = keyWord;
  }

  public void setTimes(int times) {
    this.times = times;
  }

  public void setTmstamp(long tmstamp) {
    this.tmstamp = tmstamp;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    SearchWord newWord = new SearchWord(this.keyWord, this.times, this.tmstamp);
    return newWord;
  }
}