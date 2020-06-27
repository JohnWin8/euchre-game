package com.jwin.euchre.players;

import com.jwin.euchre.pieces.Card;
import com.jwin.euchre.pieces.Card.SUIT;

public class CPU extends Player {
  public enum DIFFICULTY {
    EASY, NORMAL, HARD
  }
  
  private DIFFICULTY difficulty;
  
  public CPU(String name, DIFFICULTY difficulty) {
    super(name);
    this.difficulty = difficulty;
  }
  
  @Override
  public Card play(SUIT currentSuit) {
    return null;
  }
}
