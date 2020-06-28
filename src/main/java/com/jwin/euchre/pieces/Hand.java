package com.jwin.euchre.pieces;

import static com.jwin.euchre.pieces.Card.CardVal;
import static com.jwin.euchre.pieces.Card.SUIT;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class Hand {
  private ArrayList<Card> cards = new ArrayList<>();
  static final int HANDSIZE = 5;
  
  public Hand(ArrayList<Card> cards) {
    if (cards.size() > HANDSIZE)
      throw new IllegalArgumentException(
          "Can't create a hand with more than " + HANDSIZE + " cards, tried to have " + cards.size() + " cards");
    this.cards = cards;
  }
  
  public List<Card> getAllCardsOfASuit(SUIT suit) {
    ArrayList<Card> ret = new ArrayList<>();
    for (Card c : cards) {
      if (c.getMySuit() == suit)
        ret.add(c);
    }
    return ret;
  }
  
  public void dealTo(Card c) {
    cards.add(c);
  }
  
  public void dealTo(ArrayList<Card> cardList) {
    if (cardList.size() > HANDSIZE)
      throw new IllegalArgumentException("Dealing a list of cards to a hand with too many cards!");
    for (Card c : cardList)
      cards.add(c);
  }
  
  // returns true if the card was in the hand and false otherwise
  public boolean removeFromHand(Card card) {
    for (Card c : cards) {
      if (c.equals(card)) {
        cards.remove(c);
        return true;
      }
    }
    return false;
  }
  
  public boolean isLegalToPlay(Card card, Optional<SUIT> currentSuit) {
    if (!cards.contains(card))
      return false;
    if (!currentSuit.isPresent())
      return true;
    if (!card.getMySuit().equals(currentSuit.get()) && getAllCardsOfASuit(currentSuit.get()).size() > 0)
      return false;
    
    return true;
  }
  
  public ArrayList<Card> allCards() {
    return cards;
  }
  
  public static void main(String[] args) {
    
    Hand h = new Hand();
    ArrayList<Card> list = new ArrayList<>();
    list.add(new Card(SUIT.SPADES, CardVal.ACE));
    list.add(new Card(SUIT.SPADES, CardVal.JACK));
    
    h.dealTo(list);
    
    List<Card> suits = h.getAllCardsOfASuit(SUIT.SPADES);
    System.out.println("The spades are: ");
    for (Card c : suits)
      System.out.println(c.toString());
    if (h.getAllCardsOfASuit(SUIT.HEARTS).isEmpty())
      System.out.println("WOot Woot! getAllCardsOfASuit Works!");
    
    h.removeFromHand(new Card(SUIT.SPADES, CardVal.ACE));
    suits = h.getAllCardsOfASuit(SUIT.SPADES);
    for (Card c : suits)
      System.out.println(c.toString());
    
    list.add(new Card(SUIT.HEARTS, CardVal.QUEEN));
    h.dealTo(list);
    suits = h.getAllCardsOfASuit(SUIT.HEARTS);
    System.out.println("Printing hearts");
    for (Card c : suits)
      System.out.println(c.toString());
    
    suits = h.allCards();
    System.out.println("Printing all");
    for (Card c : suits)
      System.out.println(c.toString());
  }
  
}
