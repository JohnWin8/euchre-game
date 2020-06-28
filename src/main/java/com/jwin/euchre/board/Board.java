package com.jwin.euchre.board;

import com.jwin.euchre.io.IOController;
import com.jwin.euchre.pieces.Deck;
import com.jwin.euchre.players.CPU;
import com.jwin.euchre.players.Player;
import com.jwin.euchre.players.User;

import lombok.Getter;

public class Board {
  @Getter
  private int team1Score = 0;
  @Getter
  private int team2Score = 0;
  private Player p1;
  private Player p2;
  private Player p3;
  private Player user;

  IOController io;
  private Deck deck;
  
  public Board(CPU.DIFFICULTY diff1, CPU.DIFFICULTY diff2, CPU.DIFFICULTY diff3, String username, IOController io) {
    p1 = new CPU("CPU1", diff1);
    p2 = new CPU("CPU2", diff2);
    p3 = new CPU("CPU3", diff3);
    user = new User(username, io);
    
    deck = new Deck(io);
    this.io = io;
  }
  
}
