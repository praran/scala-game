package com.game.rps.strategy

import com.game.rps.core.round.{RPSGame, PlayerAndScore, GameRound}
import com.game.rps.model.Message._
import com.game.rps.player.Player
import com.game.rps.reader.InputReader
import com.game.rps.utils.ConsoleUtils._


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








