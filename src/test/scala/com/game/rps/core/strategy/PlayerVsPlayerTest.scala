package com.game.rps.core.strategy

import java.io.ByteArrayOutputStream

import com.game.rps.model.GameShapes.{PAPER, ROCK, SCISSORS}
import com.game.rps.model.player.HumanPlayer
import com.game.rps.reader.InputReader
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification


class PlayerVsPlayerTest extends Specification with Mockito {
  "Player vs Player game specifications" >> {

    "Player vs Player must play for specified rounds" >> {
      val player1 = spy(new HumanPlayer("player1"))
      val player2 = spy(new HumanPlayer("player2"))
      val inputReader = mock[InputReader]
      val out = new ByteArrayOutputStream()

      inputReader.readShape(anyString) returns(SCISSORS, PAPER, SCISSORS, PAPER, SCISSORS, PAPER)

      val res = Console.withOut(out) {
        new PlayerVsPlayerStrategy(3, player1, player2, inputReader).play()
      }
      res.size must_== 3

    }

    "Player vs Player must play for specified rounds and player1 wins all" >> {
      val player1 = spy(new HumanPlayer("player1"))
      val player2 = spy(new HumanPlayer("player2"))
      val inputReader = mock[InputReader]
      val out = new ByteArrayOutputStream()

      inputReader.readShape(anyString) returns(SCISSORS, PAPER, SCISSORS, PAPER, SCISSORS, PAPER)

      val res = Console.withOut(out) {
        new PlayerVsPlayerStrategy(3, player1, player2, inputReader).play()
      }
      val t = res.last

      t.winner.player.getName must_== "player1"
      t.winner.score must_== 3
      res.size must_== 3

    }
    "Player vs Player must be able to play for specified rounds and player1 and player2 wins some games" >> {
      val player1 = spy(new HumanPlayer("player1"))
      val player2 = spy(new HumanPlayer("player2"))
      val inputReader = mock[InputReader]
      val out = new ByteArrayOutputStream()

      inputReader.readShape(anyString) returns(SCISSORS, PAPER, SCISSORS, PAPER, SCISSORS, ROCK)

      val res = Console.withOut(out) {
        new PlayerVsPlayerStrategy(3, player1, player2, inputReader).play()
      }
      val r = res.last
      val w = r.winner
      val l = r.looser

      if (w.score > l.score) {
        w.score must_== 2
        l.score must_== 1
      } else {
        w.score must_== 1
        l.score must_== 2
      }

      res.size must_== 3

    }

  }

}
