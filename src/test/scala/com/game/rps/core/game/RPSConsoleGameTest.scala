package com.game.rps.core.game

import java.io.ByteArrayOutputStream

import com.game.rps.model.GameRoundModel.{GameRoundResult, PlayerAndScore}
import com.game.rps.model.Result.Won
import com.game.rps.model.player.HumanPlayer
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

import scala.collection.mutable.ArrayBuffer


class RPSConsoleGameTest extends Specification with Mockito {

  "Tests for print summary" >> {


    "Check if suitable message printed when summary not available" >> {
      val out = new ByteArrayOutputStream()
      val game = new RPSConsoleGame()
      val rounds = ArrayBuffer.empty[GameRoundResult]

      Console.withOut(out) {
        game.printSummary(rounds)
      }
      out.toString must_== "Summary Unavailable\n"

    }

    "Check if summary is printed correctly when has rounds and player1 wins" >> {
      val out = new ByteArrayOutputStream()
      val game = new RPSConsoleGame()
      val rounds = ArrayBuffer.empty[GameRoundResult]

      val g1 = new GameRoundResult(1, Won, winner = new PlayerAndScore(new HumanPlayer("player1"), 1), looser = new PlayerAndScore(new HumanPlayer("player2"), 0))
      val g2 = new GameRoundResult(1, Won, winner = new PlayerAndScore(new HumanPlayer("player1"), 2), looser = new PlayerAndScore(new HumanPlayer("player2"), 0))

      rounds.+=(g1, g2)

      Console.withOut(out) {
        game.printSummary(rounds)
      }
      out.toString must_== "player1 wins 2 - 0  player2\n"
    }

    "Check if summary is printed correctly when player2 wins " >> {
      val out = new ByteArrayOutputStream()
      val game = new RPSConsoleGame()
      val rounds = ArrayBuffer.empty[GameRoundResult]

      val g1 = new GameRoundResult(1, Won, winner = new PlayerAndScore(new HumanPlayer("player1"), 1), looser = new PlayerAndScore(new HumanPlayer("player2"), 0))
      val g2 = new GameRoundResult(1, Won, winner = new PlayerAndScore(new HumanPlayer("player1"), 0), looser = new PlayerAndScore(new HumanPlayer("player2"), 2))

      rounds.+=(g1, g2)

      Console.withOut(out) {
        game.printSummary(rounds)
      }
      out.toString must_== "player2 wins 2 - 0  player1\n"
    }


    "Check if summary is printed correctly when game tied " >> {
      val out = new ByteArrayOutputStream()
      val game = new RPSConsoleGame()
      val rounds = ArrayBuffer.empty[GameRoundResult]

      val g1 = new GameRoundResult(1, Won, winner = new PlayerAndScore(new HumanPlayer("player1"), 1), looser = new PlayerAndScore(new HumanPlayer("player2"), 0))
      val g2 = new GameRoundResult(1, Won, winner = new PlayerAndScore(new HumanPlayer("player1"), 2), looser = new PlayerAndScore(new HumanPlayer("player2"), 2))

      rounds.+=(g1, g2)

      Console.withOut(out) {
        game.printSummary(rounds)
      }
      out.toString must_== "Game Tied player1  2 - 2 player2\n"
    }

  }

}
