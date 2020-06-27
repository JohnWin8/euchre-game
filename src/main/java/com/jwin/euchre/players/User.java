package com.jwin.euchre.players;

import static com.jwin.euchre.pieces.Card.CardVal;
import static com.jwin.euchre.pieces.Card.SUIT;

import java.util.ArrayList;
import java.util.Scanner;

import com.jwin.euchre.exceptions.NoSuchEnumException;
import com.jwin.euchre.pieces.Card;

public class User extends Player {
  Scanner scanner;
  
  public User(String name, Scanner scanner) {
    super(name);
    this.scanner = scanner;
  }
  
  @Override
  public Card play(SUIT currentSuit) {
    Card toPLay = pickCard(currentSuit);
    return toPLay;
  }
  
  private Card pickCard(SUIT currentSuit) {
    if (this.hand.allCards().isEmpty())
      throw new Error("No cards left in the hand of " + this.name); // TODO : Fix exception
      
    ArrayList<Card> cards = hand.allCards();
    for (Card c : cards) {
      System.out.println(c);
    }
    
    Card cardToPlay;
    
    // read in 2 strings, first the getMySuit, then the value
    while (true) {
      System.out.print("Pick a card to removeFromHand: ");

      if (!scanner.hasNext())
        throw new RuntimeException("Scanner ended while game was still playing");
      String suit = scanner.next().toUpperCase();
      String val = scanner.next().toUpperCase();
      
      SUIT theSuit;
      CardVal theVal;
      
      try {
        theSuit = SUIT.wordToSuit(suit);
      } catch (NoSuchEnumException e) {
        System.out.println(e.getMessage());
        continue;
      }
      
      try {
        theVal = CardVal.wordToCardVal(val);
      } catch (NoSuchEnumException e) {
        System.out.println(e.getMessage());
        continue;
      }
      
      cardToPlay = new Card(theSuit, theVal);
      
      if (hand.isLegalToPlay(cardToPlay, currentSuit))
        break;
      
      System.out
          .println("The card you tried to play " + cardToPlay.toString() + " is not in your hand or not legal to play");
      System.out.println("Please play a legal card from your hand");
    }
    
    return cardToPlay;
  }
  
}
