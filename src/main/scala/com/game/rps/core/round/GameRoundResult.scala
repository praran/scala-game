package com.game.rps.core.round

import com.game.rps.model.Result.{Tie, Outcome, Lost, Won}
import com.game.rps.player.Player


trait Game {

  type PlayerAndScore = (Player, Int)

  /**
   * Each round return the game round object
   * @param
   * @return
   */
  def play(gameRound : GameRound): GameRoundResult

}

object RPSGame extends Game {

  /**
   * @inheritdoc
   * @param
   * @return
   */

  /*override def play(round : Int, p1 : Player , p2 : Player): GameRoundResult = {

    p1.play(p2.getMove) match {
      case Won  =>  p1.setScore(p1.getScore+1); new GameRoundResult(round, Won,p1, p2)
      case Lost =>  p2.setScore(p2.getScore+1); new GameRoundResult(round, Won,p2, p1)
      case Tie  => new GameRoundResult(round,Tie, p1, p2)
    }

  }*/

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


case class PlayerAndScore(player :Player, score: Int)
case class GameRound(round:Int , player1 : PlayerAndScore, player2 :PlayerAndScore)

/**
 * Game round result container object
 * The winner is stored to left and looser to right
 * @param round
 * @param winner
 * @param looser
 */
case class GameRoundResult1(round: Int,
                     outcome : Outcome,
                     winner: Player,
                     looser: Player) {
  override def toString = {
    outcome match{
      case Tie => s"Round $round : Tie \n   ${winner.getName} Score : ${winner.getScore} \n     ${looser.getName} Score : ${looser.getScore} \n "
      case _   => s"Round $round \n    Winner : ${winner.getName} Score : ${winner.getScore} \n    Looser : ${looser.getName} Score : ${looser.getScore} \n"
    }

  }
}


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

