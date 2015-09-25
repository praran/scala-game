package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{PlayerAndScore, GameRound, RPSGame}
import com.game.rps.model.{Message, GameShapes}
import com.game.rps.player.{BotPlayer, HumanPlayer}
import com.game.rps.reader.{ConsoleReader, InputReader}
import com.game.rps.utils.ConsoleUtils._
import Message._


class PlayerVsBotStrategy (val inputReader:InputReader = ConsoleReader) extends GameStrategy {

  implicit val movesGenerator = RPSMovesGenerator(GameShapes.allShapes)

  override val noOfRounds = readInteger(MESS_NO_OF_ROUNDS)
  val player1 = new HumanPlayer(readString(MESS_PLAYER1_NAME))
  val player2 = new BotPlayer("Hulk")


  override def play(): Unit = {
    var gameRound = new GameRound(1, new PlayerAndScore(player1,0), new PlayerAndScore(player2,0))
    1 to noOfRounds foreach { i =>
      player1.setMove(readShape(MESS_PLAYER1_MOVE))
      val gr = RPSGame.play(gameRound)
      gameRound = new GameRound(i+1,gr.winner , gr.looser)
      println(gr.toString)
    }

    //(1 to noOfRounds).flatMap()
  }

}
