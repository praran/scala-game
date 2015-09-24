package com.game.rps.core.round

import com.game.rps.player.Player


trait Game {

  def play(round : GameRound) : GameRound

}

object RPSGame extends Game{

  override def play(round: GameRound): GameRound = {
     val w = round.winner
     val l = round.looser
     w._1.isBeatenBy(l._1) match {
       case false => new GameRound(round.round, (w._1, w._2+1),l)
       case true  => new GameRound(round.round, (l._1, l._2+1), w)
     }

  }
}



case class GameRound(round:Int, winner : (Player, Int), looser :(Player, Int)){
  override def toString(): String ={
    return s"Round $round \n    Winner : ${winner._1.getName()} Score : ${winner._2} \n    Looser : ${looser._1.getName()} Score : ${looser._2} \n"
  }
}
