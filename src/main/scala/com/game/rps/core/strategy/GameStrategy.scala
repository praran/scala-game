package com.game.rps.core.strategy

import com.game.rps.model.GameRoundModel.GameRoundResult


/**
 * Contract for game strategies
 */
trait GameStrategy {

  /**
   * Returns a list of game round results
   * @return
   */
  def play(): Traversable[GameRoundResult]


}








