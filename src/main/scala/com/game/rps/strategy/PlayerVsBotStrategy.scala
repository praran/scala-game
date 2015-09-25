package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.RPSGame
import com.game.rps.model.GameShapes
import com.game.rps.player.{BotPlayer, HumanPlayer}
import com.game.rps.utils.ConsoleUtils._
import com.game.rps.utils.Message._


class PlayerVsBotStrategy extends GameStrategy {

  implicit val movesGenerator = RPSMovesGenerator(GameShapes.allShapes)
  val rounds = Nil

  val noOfRounds = readInteger(MESS_NO_OF_ROUNDS)
  val player1 = new HumanPlayer(readString(MESS_PLAYER1_NAME))
  val player2 = new BotPlayer("Hulk")


  override def play(): Unit = {
    1 to noOfRounds foreach { i =>
      player1.setMove(readShape(MESS_PLAYER1_MOVE))
      val gr = RPSGame.play(i, player1, player2)
      println(gr.toString)
    }
    rounds.foreach(r => println(r.toString))
  }

}
