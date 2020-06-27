package com.jwin.euchre.main;

import java.util.ArrayList;
import java.util.List;

import com.jwin.euchre.pieces.Card;

public class Main {
  public static void main(String[] args) {
    List<Card> list = new ArrayList<>();
    list.add(new Card(Card.SUIT.CLUBS, Card.CardVal.ACE));
    list.add(new Card(Card.SUIT.DIAMONDS, Card.CardVal.NINE));
    System.out.println(list.contains(new Card(Card.SUIT.DIAMONDS, Card.CardVal.NINE)) + " : expected true");
    System.out.println(list.contains(new Card(Card.SUIT.CLUBS, Card.CardVal.KING)) + " : expected false");
  }
  
  public static String getWord() {
    return "hello world";
  }
}
