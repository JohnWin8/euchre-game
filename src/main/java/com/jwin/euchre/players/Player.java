package com.jwin.euchre.players;

import com.jwin.euchre.pieces.Card;
import com.jwin.euchre.pieces.Hand;
import com.jwin.euchre.pieces.Card.SUIT;

import java.util.ArrayList;

public abstract class Player {
  
  public final String name;
  protected Hand hand;
  
  public Player(String name) {
    this.name = name;
    hand = new Hand();
  }
  
  public void getDealt(Card card) {
    // give the card to hand
    hand.dealTo(card);
  }
  
  public void getDealt(ArrayList<Card> clist) {
    hand.dealTo(clist);
  }
  
  public abstract Card play(SUIT currentSuit);
  
}
