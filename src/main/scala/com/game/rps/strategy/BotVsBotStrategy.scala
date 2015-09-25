package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{PlayerAndScore, GameRound, GameRoundResult, RPSGame}
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
    var gameRound = new GameRound(1, new PlayerAndScore(player1, 0), new PlayerAndScore(player2, 0))
    1 to noOfRounds foreach { i =>
      val gameResult = RPSGame.play(gameRound)
      gameRound = new GameRound(i + 1, gameResult.winner, gameResult.looser)
      println(gameResult.toString)
    }
  }

}