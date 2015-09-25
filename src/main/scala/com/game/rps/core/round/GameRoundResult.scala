package com.game.rps.core.round

import com.game.rps.model.Result.{Tie, Outcome, Lost, Won}
import com.game.rps.player.Player


trait Game {

  /**
   * Each round return the game round object
   * @param gameRound
   * @return
   */
  def play(gameRound : GameRound): GameRoundResult

}
/**
 * Container for player and scores
 * @param player
 * @param score
 */
case class PlayerAndScore(player :Player, score: Int)

/**
 * Container for game round
 * @param round
 * @param player1
 * @param player2
 */
case class GameRound(round:Int , player1 : PlayerAndScore, player2 :PlayerAndScore)

/**
 * Game round result container object
 * @param round
 * @param winner
 * @param looser
 */
case class GameRoundResult(round: Int,
                           outcome : Outcome,
                           winner: PlayerAndScore,
                           looser: PlayerAndScore) {
  override def toString = {
    outcome match{
      case Tie => s"Round $round : Tie \n   ${winner.player.getName} Score : ${winner.score} \n     ${looser.player.getName} Score : ${looser.score} \n "
      case _   => s"Round $round \n    Winner : ${winner.player.getName} Score : ${winner.score} \n    Looser : ${looser.player.getName} Score : ${looser.score} \n"
    }

  }
}


object RPSGame extends Game {

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




