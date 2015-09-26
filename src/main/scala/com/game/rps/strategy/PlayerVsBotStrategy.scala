package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{RPSGame, PlayerAndScore, GameRound}
import com.game.rps.model.GameShapes
import com.game.rps.model.Message._
import com.game.rps.player.{BotPlayer, HumanPlayer}
import com.game.rps.reader.{ConsoleReader, InputReader}
import com.game.rps.utils.ConsoleUtils._


class PlayerVsBotStrategy(val inputReader: InputReader = ConsoleReader)  extends  GameStrategy{

  /**
   * Implicit used for generating random moves for Bot player
   */
  implicit val movesGenerator = RPSMovesGenerator(GameShapes.allShapes)

  /**
   * No of rounds to play for game
   */
  override val noOfRounds = inputReader.readNoOfRound(MESS_NO_OF_ROUNDS)

  // Set the human player
  val player1 = new HumanPlayer(inputReader.readName(MESS_PLAYER1_NAME))

  // Set the bot player
  val player2 = new BotPlayer("Hulk")

  override def play(): Unit = {
    var gameRound = new GameRound(1, new PlayerAndScore(player1, 0), new PlayerAndScore(player2, 0))
    1 to noOfRounds foreach { i =>
      player1.setMove(inputReader.readShape(MESS_PLAYER1_MOVE))
      val gameResult = RPSGame.play(gameRound)
      gameRound = new GameRound(i + 1, gameResult.winner, gameResult.looser)
      println(gameResult.toString)
    }
  }


}
