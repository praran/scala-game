package com.game.rps.core.game

import com.game.rps.core.movesgenerator.RPSMovesGenerator
import com.game.rps.core.strategy.{PlayerVsBotStrategy, PlayerVsPlayerStrategy, BotVsBotStrategy}
import com.game.rps.model.GameRoundModel.{PlayerAndScore, GameRoundResult}
import com.game.rps.model.GameShapes
import com.game.rps.model.player.{HumanPlayer, BotPlayer}
import com.game.rps.reader.ConsoleReader
import com.game.rps.utils.ConsoleUtils._
import com.game.rps.model.Message._

import scala.collection.mutable.ArrayBuffer

/**
 * Created by pradeep on 26/09/2015.
 */
class RPSConsoleGame {

  implicit val movesGenerator: RPSMovesGenerator = RPSMovesGenerator(GameShapes.allShapes)

  def playGame : Unit = {

    println("**************************\n" +
      "* Rock , Paper, Scissors *\n"+
      "**************************\n"+
      "Choose options and press enter press ctrl + c to terminate\n"+
      "    1 for Bot Vs Bot \n"+
      "    2 for Player Vs Player \n"+
      "    3 for Player Vs Bot \n")


    readInteger("") match {
      case 1 => setUpBotVsBotGame()
      case 2 => setUpHumanVsHuman()
      case 3 => setUpHumanVsBot()
      case _ => println("Invalid choice")
    }

  }


  /**
   * Set up for different strategies
   * these can be intialized via IOC container
   */
  private def setUpBotVsBotGame(): Unit ={
    val noOfRounds = ConsoleReader.readNoOfRound(MESS_NO_OF_ROUNDS)
    val player1 = new  BotPlayer("Veronica")
    val player2 = new BotPlayer("Hulk")
    val res =  new BotVsBotStrategy(noOfRounds, player1, player2).play()
    printSummary(res)
  }


  private def setUpHumanVsHuman() ={
    val noOfRounds = ConsoleReader.readNoOfRound(MESS_NO_OF_ROUNDS)
    val player1 = new  HumanPlayer(ConsoleReader.readName(MESS_PLAYER1_NAME))
    val player2 = new  HumanPlayer(ConsoleReader.readName(MESS_PLAYER2_NAME))
    val res = new PlayerVsPlayerStrategy(noOfRounds, player1, player2).play()
    printSummary(res)
  }


  private def setUpHumanVsBot() = {
    val noOfRounds = ConsoleReader.readNoOfRound(MESS_NO_OF_ROUNDS)
    val player1 = new  HumanPlayer(ConsoleReader.readName(MESS_PLAYER1_NAME))
    val player2 = new  BotPlayer("Hulk")
    val res = new PlayerVsBotStrategy(noOfRounds, player1, player2).play()
    printSummary(res)
  }


  /**
   * Helper method to print summary
   * @param rounds
   */
  private def printSummary(rounds : ArrayBuffer[GameRoundResult]): Unit ={

    def print(p1 : PlayerAndScore, p2 : PlayerAndScore)= {
       if(p1.score > p2.score)
         println(s"${p1.player.getName} wins ${p1.score} - ${p2.score}  ${p2.player.getName}")
       else
         println(s"${p2.player.getName} wins ${p2.score} - ${p1.score}  ${p1.player.getName}")
    }

    rounds.lastOption match {
      case Some(r) => print(r.winner, r.looser)
      case None    => println(s"Summary Unavailable")
    }


  }

}