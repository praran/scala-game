package com.game.rps.core.strategy

import com.game.rps.core.round.{GameRoundPlay, RPSGameRoundPlay}
import com.game.rps.model.GameRoundModel._
import com.game.rps.model.Message._
import com.game.rps.model.player.{BotPlayer, HumanPlayer, Player}
import com.game.rps.reader.{ConsoleReader, InputReader}

import scala.collection.mutable.ArrayBuffer

class PlayerVsBotStrategy( noOfRounds:Int
                           , player1 : HumanPlayer
                           , player2 : BotPlayer
                           , inputReader: InputReader = ConsoleReader
                           , gameRoundPlay : GameRoundPlay = RPSGameRoundPlay)  extends  GameStrategy{



  val result = ArrayBuffer.empty[GameRoundResult]


  override def play()= {
    var gameRound = new GameRound(1, new PlayerAndScore(player1, 0), new PlayerAndScore(player2, 0))
    1 to noOfRounds foreach { i =>
      player1.setMove(inputReader.readShape(MESS_PLAYER1_MOVE))
      val gameResult = gameRoundPlay.play(gameRound)
      gameRound = new GameRound(i + 1, gameResult.winner, gameResult.looser)
      result.+=(gameResult)
      println(gameResult.toString)
    }
    result
  }


}
