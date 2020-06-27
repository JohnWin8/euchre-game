package com.jwin.euchre.pieces;

import com.jwin.euchre.exceptions.NoSuchEnumException;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class Card {
  public enum SUIT {
    SPADES, HEARTS, CLUBS, DIAMONDS;
    
    public static SUIT wordToSuit(String word) throws NoSuchEnumException {
      for (SUIT s : SUIT.values()) {
        if (word.toUpperCase().equals(s.name()))
          return s;
      }
      throw new NoSuchEnumException(
          "You tried to make a suit " + word + " your options are: " + SUIT.appendAllSuitNames());
    }
    
    protected static String appendAllSuitNames() {
      StringBuilder ret = new StringBuilder();
      for (SUIT suit : SUIT.values()) {
        ret.append(suit.name()).append(" ");
      }
      return ret.toString().trim();
    }
  }
  
  public enum CardVal {
    NINE, TEN, JACK, QUEEN, KING, ACE;
    
    public static CardVal wordToCardVal(String word) throws NoSuchEnumException {
      for (CardVal cv : CardVal.values()) {
        if (word.toUpperCase().equals(cv.name()))
          return cv;
      }
      throw new NoSuchEnumException(
          "You tried a card value " + word + " your options are " + CardVal.appendAllCardVals());
    }
    
    protected static String appendAllCardVals() {
      StringBuilder ret = new StringBuilder();
      for (CardVal val : CardVal.values()) {
        ret.append(val.name()).append(" ");
      }
      return ret.toString().trim();
    }
  }
  
  private SUIT mySuit;
  private CardVal myVal;
  
  @Override
  public String toString() {
    return mySuit.toString() + " " + myVal.toString();
  }
}
