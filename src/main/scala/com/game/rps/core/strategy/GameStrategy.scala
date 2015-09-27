package com.game.rps.core.strategy

import com.game.rps.model.GameRoundModel.GameRoundResult
import com.game.rps.reader.InputReader


trait GameStrategy {

  /**
   * Play game
   */
  def play() : Traversable[GameRoundResult]


}








