package com.jwin.euchre.players;

import static com.jwin.euchre.pieces.Card.CardVal;
import static com.jwin.euchre.pieces.Card.SUIT;

import java.util.ArrayList;
import java.util.Optional;

import com.jwin.euchre.exceptions.NoMoreInputException;
import com.jwin.euchre.exceptions.NoSuchEnumException;
import com.jwin.euchre.io.IOController;
import com.jwin.euchre.pieces.Card;

public class User extends Player {
  IOController io;
  
  public User(String name, IOController io) {
    super(name);
    this.io = io;
  }
  
  @Override
  public Card play(Optional<SUIT> currentSuit, SUIT currentTrump) {
    Card toPLay;
    try {
      toPLay = pickCard(currentSuit);
    } catch (NoMoreInputException nmie) {
      throw new RuntimeException(nmie.toString() + " when asking User to play");
    }
    return toPLay;
  }
  
  private Card pickCard(Optional<SUIT> currentSuit) throws NoMoreInputException {
    if (this.hand.allCards().isEmpty())
      throw new Error("No cards left in the hand of " + this.name); // TODO : Fix exception
      
    ArrayList<Card> cards = hand.allCards();
    for (Card c : cards) {
      io.outputString(c.toString());
    }
    
    Card cardToPlay;
    
    // read in 2 strings, first the getMySuit, then the value
    while (true) {
      io.outputString("Pick a card to play: ");
      
      String suit = io.inputStringWord();
      String val = io.inputStringWord();
      
      SUIT theSuit;
      CardVal theVal;
      
      try {
        theSuit = SUIT.wordToSuit(suit);
      } catch (NoSuchEnumException e) {
        io.outputError(e);
        continue;
      }
      
      try {
        theVal = CardVal.wordToCardVal(val);
      } catch (NoSuchEnumException e) {
        io.outputError(e);
        continue;
      }
      
      cardToPlay = new Card(theSuit, theVal);
      
      if (hand.isLegalToPlay(cardToPlay, currentSuit))
        break;
      
      io.outputString(
          "The card you tried to play " + cardToPlay.toString() + " is not in your hand or not legal to play");
      io.outputString("Please play a legal card from your hand");
    }
    
    return cardToPlay;
  }
  
}
