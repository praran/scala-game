package com.game.rps.strategy

import com.game.rps.core.round.{PlayerAndScore, GameRound, GameRoundResult, RPSGame}
import com.game.rps.model.Message
import com.game.rps.player.HumanPlayer
import com.game.rps.reader.{ConsoleReader, InputReader}
import com.game.rps.utils.ConsoleUtils._
import Message._


class PlayerVsPlayerStrategy (reader:InputReader = ConsoleReader) extends GameStrategy {

  val rounds: List[GameRoundResult] = Nil
  val noOfRounds = readInteger(MESS_NO_OF_ROUNDS)
  val player1 = new HumanPlayer(readString(MESS_PLAYER1_NAME))
  val player2 = new HumanPlayer(readString(MESS_PLAYER2_NAME))

  override  val inputReader = reader

  override def play(): Unit = {
    var gameRound = new GameRound(1, new PlayerAndScore(player1, 0), new PlayerAndScore(player2, 0))
    1 to noOfRounds foreach { i =>
      player1.setMove(readShape(MESS_PLAYER1_MOVE))
      player2.setMove(readShape(MESS_PLAYER1_MOVE))
      val gameResult = RPSGame.play(gameRound)
      gameRound = new GameRound(i + 1, gameResult.winner, gameResult.looser)
      println(gameResult.toString)
    }
  }
}