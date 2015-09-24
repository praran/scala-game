package com.game.rps.core.round

import com.game.rps.model.Result.{Tie, Outcome, Lost, Won}
import com.game.rps.player.Player


trait Game {

  type playerAndScore = (Player, Int)

  /**
   * Each round return the game round object
   * @param round
   * @return
   */
  def play(round : Int, p1 : Player , p2 : Player): GameRound

}

object RPSGame extends Game {

  /**
   * @inheritdoc
   * @param round
   * @return
   */

  override def play(round : Int, p1 : Player , p2 : Player): GameRound = {

    p1.play(p2.getMove) match {
      case Won  => val s = p1.getScore+1 ; p1.setScore(s); new GameRound(round, Won,p1, p2)
      case Lost => val s = p2.getScore+1 ; p2.setScore(s); new GameRound(round, Won,p2, p1)
      case Tie  => new GameRound(round,Tie, p1, p2)
    }

  }
}


/**
 * Game round container object
 * The winner is stored to left and looser to right
 * @param round
 * @param winner
 * @param looser
 */
case class GameRound(round: Int,
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


