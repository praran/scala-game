package com.game.rps.core.strategy

import java.io.ByteArrayOutputStream

import com.game.rps.core.movesgenerator.RPSMovesGenerate
import com.game.rps.model.GameShapes.{Shape, ROCK, PAPER, SCISSORS}
import com.game.rps.model.Result.{Lost, Won}
import com.game.rps.model.player.BotPlayer
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification


class BotVsBotStrategyTest extends Specification with Mockito{


  "Bot vs Bot specifications" >> {

    "Bot and Bot must play for specified rounds" >> {
      implicit val rPSMovesGenerate = mock[RPSMovesGenerate]

      val player1 = spy(new BotPlayer("bot1"))
      val player2 = spy(new BotPlayer("bot2"))
      val out = new ByteArrayOutputStream()

      player1.getMove returns(SCISSORS, SCISSORS, SCISSORS)
      player2.getMove returns(PAPER, PAPER, PAPER)


      val res = Console.withOut(out){
        new BotVsBotStrategy(3, player1 , player2).play()
      }
      res.size must_== 3

    }

    "Bot1 and Bot2 must play for specified rounds and bot1 player wins all" >> {
      val player1 = mock[BotPlayer]
      val player2 = mock[BotPlayer]
      val out = new ByteArrayOutputStream()

     // rPSMovesGenerate.generateMove() returns (SCISSORS,SCISSORS,SCISSORS)
      player2.getMove returns(PAPER, PAPER, PAPER)
      player1.getMove returns(SCISSORS,SCISSORS,SCISSORS)
      player1.play(any[Shape]) returns(Won)
      player1.getName returns "bot1"
      player2.getName returns "bot2"

      val res = Console.withOut(out){
        new BotVsBotStrategy(3, player1 , player2).play()
      }
      val t = res.last

      t.winner.player.getName must_== "bot1"
      t.winner.score must_== 3
      res.size must_== 3

    }


    "Bot1 and Bot2 must play for specified rounds and human and bot wins some games" >> {
      // init
      val player1 = mock[BotPlayer]
      val player2 = mock[BotPlayer]
      val out = new ByteArrayOutputStream()

      // behaviour
      player2.getMove returns(PAPER, PAPER, ROCK)
      player1.getMove returns(SCISSORS,SCISSORS,SCISSORS)
      player1.play(any[Shape]) returns(Won, Won, Lost)
      player1.getName returns "bot1"
      player2.getName returns "bot2"

      // sUT
      val res = Console.withOut(out){
        new BotVsBotStrategy(3, player1 , player2).play()
      }

      // Assert
      val r = res.last
      val w =  r.winner
      val l = r.looser

      if(w.score > l.score){
        w.score must_== 2
        l.score must_== 1
      }else {
        w.score must_== 1
        l.score must_== 2
      }

      res.size must_== 3

    }
  }

}
