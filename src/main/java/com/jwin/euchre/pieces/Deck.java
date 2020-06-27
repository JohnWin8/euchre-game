package com.jwin.euchre.pieces;

import com.jwin.euchre.pieces.Card.CardVal;
import com.jwin.euchre.pieces.Card.SUIT;
import com.jwin.euchre.players.Player;
import com.jwin.euchre.players.User;

import java.util.Scanner;

public final class Deck {
  private static final int NUM_PLAYERS = 4;

  static final int deckSize = 24;
  private Card[] theDeck;
  private Player[] players;
  
  public Deck(Player p1, Player p2, Player p3, Player p4) {
    players = new Player[] { p1, p2, p3, p4 };
    theDeck = new Card[deckSize];
    int i = 0;
    
    for (SUIT s : SUIT.values()) {
      for (CardVal c : CardVal.values()) {
        theDeck[i] = new Card(s, c);
        i++;
      }
    }
  }
  
  public void printDeck() {
    for (int i = 0; i < theDeck.length; i++) {
      System.out.println(theDeck[i].toString());
    }
  }
  
  public void deal() {
    // add cards to each of the 4 players, probs by randomly splitting the deck
  }
  
  public static void main(String[] args) {
    SUIT getMySuit = SUIT.SPADES;
    System.out.println(getMySuit);
    Player p = new User("Cool dude", new Scanner(System.in));
    Deck deck = new Deck(p, p, p, p);
    deck.printDeck();
  }
}