package com.game.rps.strategy

import com.game.rps.reader.InputReader


trait GameStrategy {
  /**
   * No of rounds to be played for the game
   */
  protected val noOfRounds:Int

  /**
   * Reader to get inputs maybe console or GUI
   */
  protected val inputReader:InputReader

  /**
   * Play game
   */
  def play()

 // def play(player1:Player, player2 : Player)

  //def strToShape(str: String): Shape = GameShapes.allShapes.find(s => s.stringValue.equalsIgnoreCase(str)).get

}








