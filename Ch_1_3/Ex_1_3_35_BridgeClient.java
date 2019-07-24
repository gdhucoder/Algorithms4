package Ch_1_3;

import Ch_1_3.Ex_1_3_35._RandomQueue;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * This is a Bridge Client using RandomQueue
 * Created by HuGuodong on 2019/7/24.
 */

public class Ex_1_3_35_BridgeClient {

  public static final int CARDS_PER_PERSON = 13;

  public static class _Player {

    private String name;
    private _Card[] cards;

    public _Player(String name) {
      this.name = name;
      cards = new _Card[CARDS_PER_PERSON];
    }

    public _Card[] getCards() {
      return cards;
    }

    @Override
    public String toString() {
      return "_Player{" +
          "name='" + name + '\'' +
          ", cards=" + Arrays.toString(cards) +
          '}';
    }
  }

  public static class _Card {

    private String card;

    public _Card(String card) {
      this.card = card;
    }

    @Override
    public String toString() {
      return card;
    }
  }

  public static void main(String[] args) {
    int NUM_OF_PLAYERS = 4;
    _Player[] players = new _Player[NUM_OF_PLAYERS];
    for (int i = 0; i < players.length; i++) {
      players[i] = new _Player(String.format("player_%d", i));
    }

    // all cards
    String[][] cards = {
        {"♥A", "♥2", "♥3", "♥4", "♥5", "♥6", "♥7", "♥8", "♥9", "♥10", "♥J", "♥Q", "♥K"},
        {"♠A", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠J", "♠Q", "♠K"},
        {"♣A", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10", "♣J", "♣Q", "♣K"},
        {"♦A", "♦2", "♦3", "♦4", "♦5", "♦6", "♦7", "♦8", "♦9", "♦10", "♦J", "♦Q", "♦K"}
    };

    //
    _RandomQueue<_Card> queue = new _RandomQueue<>();
    for (int i = 0; i < cards.length; i++) {
      for (int j = 0; j < cards[0].length; j++) {
        queue.enqueue(new _Card(cards[i][j]));
      }
    }

    int cnt = 0;
    while (!queue.isEmpty()) {
      players[cnt / CARDS_PER_PERSON].getCards()[cnt % CARDS_PER_PERSON] = queue.dequeue();
      cnt++;
    }

    for (int i = 0; i < 4; i++) {
      StdOut.println(players[i]);
    }

//    _Player{name='player_0', cards=[♣3, ♥6, ♦K, ♦A, ♦10, ♥4, ♥A, ♥J, ♣8, ♣K, ♦8, ♠5, ♣A]}
//    _Player{name='player_1', cards=[♥2, ♠3, ♦Q, ♣2, ♠7, ♣5, ♥3, ♥K, ♦2, ♣Q, ♣9, ♥8, ♠K]}
//    _Player{name='player_2', cards=[♠8, ♥Q, ♠Q, ♠9, ♠J, ♣J, ♣4, ♦4, ♣6, ♣7, ♠A, ♠10, ♥9]}
//    _Player{name='player_3', cards=[♠6, ♠2, ♣10, ♥7, ♦9, ♦J, ♦5, ♦7, ♦6, ♦3, ♥10, ♠4, ♥5]}

  }
}
