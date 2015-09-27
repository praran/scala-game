package com.game.rps.core.round

import com.game.rps.model.GameRoundModel.{GameRound, GameRoundResult}

/**
 * General contract for each round of game
 */
trait GameRoundPlay {

  /**
   * Each round return the game round object
   * @param gameRound
   * @return
   */
  def play(gameRound: GameRound): GameRoundResult

}
