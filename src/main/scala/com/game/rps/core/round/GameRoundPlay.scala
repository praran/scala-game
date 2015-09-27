package com.game.rps.core.round

import com.game.rps.model.GameRoundModel.{GameRound, GameRoundResult}

/**
 * Created by pradeep on 26/09/2015.
 */
trait GameRoundPlay {

  /**
   * Each round return the game round object
   * @param gameRound
   * @return
   */
  def play(gameRound: GameRound): GameRoundResult

}
