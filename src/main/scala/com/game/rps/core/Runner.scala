package com.game.rps.core

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{GameRound, RPSGame}
import com.game.rps.model.{SCISSORS, PAPER, ROCK}
import com.game.rps.player.{Player, RPSPlayer}

/**
  */
object Runner extends  App{



   val item = Seq(ROCK, PAPER, SCISSORS)

   implicit val movesGenerator = RPSMovesGenerator(item)

   var player1:Player = new RPSPlayer("Superman")
   var player2 : Player = new RPSPlayer("Batman")



  println("hola !!!!")

  var scores = (0,0)
 (1 to 10).foreach{
   round =>
      val result = RPSGame.play(new GameRound(round, (player1,scores._1) , (player2,scores._2)) )
      println(result.toString())
     scores = (result.winner._2, result.looser._2)
     player1 = result.winner._1
     player2 = result.looser._1

  }



}
