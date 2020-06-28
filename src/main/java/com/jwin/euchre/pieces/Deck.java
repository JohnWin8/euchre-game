package com.jwin.euchre.pieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.jwin.euchre.io.IOController;
import com.jwin.euchre.pieces.Card.CardVal;
import com.jwin.euchre.pieces.Card.SUIT;
import com.jwin.euchre.players.Player;
import com.jwin.euchre.players.User;

public final class Deck {
  static final int deckSize = 24;
  private Card[] theDeck;
  private IOController io;
  
  public Deck(IOController io) {
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
      io.outputString(theDeck[i].toString());
    }
  }
  
  public List<Card> deal() {
    List<Card> ret = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < deckSize; i++)
      numbers.add(i);
    Collections.shuffle(numbers);
    for (int i = 0; i < deckSize; i++) {
      ret.add(theDeck[numbers.get(i)]);
    }
    return ret;
  }
  
  public static void main(String[] args) {
    SUIT getMySuit = SUIT.SPADES;
    System.out.println(getMySuit);
//    Player p = new User("Cool dude", new Scanner(System.in));
//    Deck deck = new Deck();
//    deck.printDeck();
  }
}