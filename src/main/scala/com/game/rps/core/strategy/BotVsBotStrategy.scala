package com.game.rps.core.strategy

import com.game.rps.core.round.{GameRoundPlay, RPSGameRoundPlay}
import com.game.rps.model.GameRoundModel._
import com.game.rps.model.player.BotPlayer

import scala.collection.mutable.ArrayBuffer

/**
 * Strategy for Bot Vs Bot RPS game
 * @param noOfRounds
 * @param player1
 * @param player2
 * @param gameRoundPlay
 */
class BotVsBotStrategy(noOfRounds: Int
                       , player1: BotPlayer
                       , player2: BotPlayer
                       , gameRoundPlay: GameRoundPlay = RPSGameRoundPlay
                        ) extends GameStrategy {
  val result = ArrayBuffer.empty[GameRoundResult]


  /**
   * @inheritdoc
   * @return
   */
  override def play() = {
    var gameRound = new GameRound(1, new PlayerAndScore(player1, 0), new PlayerAndScore(player2, 0))
    1 to noOfRounds foreach { i =>
      val gameResult = gameRoundPlay.play(gameRound)
      gameRound = new GameRound(i + 1, gameResult.winner, gameResult.looser)
      println(gameResult.toString)
      result.+=(gameResult)
    }
    result
  }

}