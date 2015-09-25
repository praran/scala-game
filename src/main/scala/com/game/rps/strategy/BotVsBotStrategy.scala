package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{GameRoundResult, RPSGame}
import com.game.rps.model.{Message, GameShapes}
import com.game.rps.player.BotPlayer
import com.game.rps.reader.{ConsoleReader, InputReader}
import com.game.rps.utils.ConsoleUtils._
import Message._


class BotVsBotStrategy (val inputReader:InputReader = ConsoleReader)extends GameStrategy {
  implicit val movesGenerator = RPSMovesGenerator(GameShapes.allShapes)
  val rounds: List[GameRoundResult] = Nil


  val noOfRounds = readInteger(MESS_NO_OF_ROUNDS)
  val player1 = new BotPlayer("Veronica")
  val player2 = new BotPlayer("Hulk")

  override def play(): Unit = {
    1 to noOfRounds foreach { i =>
      /*val gr = RPSGame.play(i, player1, player2)
      println(gr.toString)*/
    }
  }

}