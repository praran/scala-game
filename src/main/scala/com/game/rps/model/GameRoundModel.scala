package com.game.rps.model

import com.game.rps.model.Result.{Outcome, Tie}
import com.game.rps.model.player.Player

/**
 * various container objects for RPS games
 */
object GameRoundModel {


  /**
   * Container for player and scores
   * @param player
   * @param score
   */
  case class PlayerAndScore(player: Player, score: Int)

  /**
   * Container for game round
   * @param round
   * @param player1
   * @param player2
   */
  case class GameRound(round: Int, player1: PlayerAndScore, player2: PlayerAndScore)

  /**
   * Game round result container object
   * @param round
   * @param winner
   * @param looser
   */
  case class GameRoundResult(round: Int,
                             outcome: Outcome,
                             winner: PlayerAndScore,
                             looser: PlayerAndScore) {
    override def toString = {
      outcome match {
        case Tie => s"Round $round : Tie \n   ${winner.player.getName} Score : ${winner.score} \n     ${looser.player.getName} Score : ${looser.score} \n "
        case _ => s"Round $round \n    Winner : ${winner.player.getName} Score : ${winner.score} \n    Looser : ${looser.player.getName} Score : ${looser.score} \n"
      }

    }
  }


}
