package com.game.rps.core

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{GameRound, RPSGame}
import com.game.rps.model.GameShapes.{SCISSORS, PAPER, ROCK}
import com.game.rps.player.{HumanPlayer, Player, BotPlayer}
import com.game.rps.strategy.{BotVsBot, PlayerVsBot, PlayerVsPlayer}

/**
  */
object Runner extends  App{



//   val item = Seq(ROCK, PAPER, SCISSORS)
//
//   implicit val movesGenerator = RPSMovesGenerator(item)

////   var player1:Player = new BotPlayer("Superman")
//    var player2 : Player = new BotPlayer("Batman")
//
//  var player1:Player = new HumanPlayer("Superman")
//  //var player2 : Player = new HumanPlayer("Batman")
//
//  val game = new PlayerVsBot(2, player1, player2)


  println("hola !!!!")

  println("Rock , Paper, Scissors")
  println("Choose options and press enter")
  println("    1 for Bot Vs Bot")
  println("    2 for Player Vs Player")
  println("    3 for Player Vs Bot")
  io.StdIn.readInt() match {
    case 1 => new BotVsBot().play()
    case 2 => new PlayerVsPlayer().play()
    case 3 => new PlayerVsBot().play()
  }






  /*var scores = (0,0)
 (1 to 10).foreach{
   round =>
      val result = RPSGame.play(new GameRound(round, (player1,scores._1) , (player2,scores._2)) )
      println(result.toString())
     scores = (result.winner._2, result.looser._2)
     player1 = result.winner._1
     player2 = result.looser._1

  }*/



}
