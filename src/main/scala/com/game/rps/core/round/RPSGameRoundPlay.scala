package com.game.rps.core.round

import com.game.rps.model.GameRoundModel.{PlayerAndScore, GameRoundResult, GameRound}
import com.game.rps.model.Result.{Tie, Lost, Won}

object RPSGameRoundPlay extends GameRoundPlay {

  /**
   * @inheritdoc
   */
  def play(gameRound : GameRound): GameRoundResult = {
    val  p1 = gameRound.player1.player
    val  p2 = gameRound.player2.player
    p1.play(p2.getMove) match {
      case Won  =>  new GameRoundResult(gameRound.round, Won,PlayerAndScore(p1, gameRound.player1.score+1), PlayerAndScore(p2, gameRound.player2.score))
      case Lost =>  new GameRoundResult(gameRound.round, Won,PlayerAndScore(p2, gameRound.player2.score+1), PlayerAndScore(p1, gameRound.player1.score))
      case Tie  =>  new GameRoundResult(gameRound.round, Tie,PlayerAndScore(p1, gameRound.player1.score), PlayerAndScore(p2, gameRound.player2.score))
    }

  }
}
