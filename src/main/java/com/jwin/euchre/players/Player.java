package com.jwin.euchre.players;

import java.util.ArrayList;

import com.jwin.euchre.pieces.Card;
import com.jwin.euchre.pieces.Card.SUIT;
import com.jwin.euchre.pieces.Hand;

public abstract class Player {
  
  public final String name;
  protected Hand hand;
  
  public Player(String name) {
    this.name = name;
    hand = new Hand();
  }
  
  public void getDealt(Card card) {
    hand.dealTo(card);
  }
  
  public void getDealt(ArrayList<Card> clist) {
    hand.dealTo(clist);
  }
  
  public abstract Card play(SUIT currentSuit);
  
}
