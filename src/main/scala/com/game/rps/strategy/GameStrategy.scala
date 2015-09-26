package com.game.rps.strategy

import com.game.rps.reader.InputReader


trait GameStrategy {
  /**
   * No of rounds to be played for the game
   */
  protected val noOfRounds: Int

  /**
   * Reader to get inputs maybe console or GUI
   */
  protected val inputReader: InputReader

  /**
   * Play game
   */
  def play()


}








