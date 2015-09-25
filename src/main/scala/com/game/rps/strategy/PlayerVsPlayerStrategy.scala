package com.game.rps.strategy

import com.game.rps.core.round.{GameRoundResult, RPSGame}
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
    1 to noOfRounds foreach { i =>
      player1.setMove(readShape(MESS_PLAYER1_MOVE))
      player2.setMove(readShape(MESS_PLAYER2_MOVE))
     /* val gr = RPSGame.play(i, player1, player2)
      rounds.::(gr)
      println(gr.toString)*/
    }
  }

}