package com.jwin.euchre.players;

import java.util.Collections;
import java.util.Optional;

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
  public Card play(Optional<SUIT> currentSuit, SUIT currentTrump) {
    if (difficulty.equals(DIFFICULTY.HARD))
      return playHard(currentSuit, currentTrump);
    else if (difficulty.equals(DIFFICULTY.NORMAL))
      return playNormal(currentSuit, currentTrump);
    
    return playEasy(currentSuit, currentTrump);
  }
  
  private Card playHard(Optional<SUIT> currentSuit, SUIT currentTrump) {
    return playEasy(currentSuit, currentTrump); // TODO add hard difficulty
  }
  
  private Card playNormal(Optional<SUIT> currentSuit, SUIT currentTrump) {
    return playEasy(currentSuit, currentTrump); // TODO add normal difficulty
  }
  
  private Card playEasy(Optional<SUIT> currentSuit, SUIT currentTrump) {
    if (!currentSuit.isPresent() || (hand.getAllCardsOfASuit(currentSuit.get()).size() < 1))
      return Collections.max(hand.allCards());
    return Collections.max(hand.getAllCardsOfASuit(currentSuit.get()));
  }
}
