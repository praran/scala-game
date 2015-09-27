package com.game.rps.core.strategy

import java.io.ByteArrayOutputStream

import com.game.rps.model.GameShapes.{ROCK, PAPER, SCISSORS}
import com.game.rps.model.player.{BotPlayer, HumanPlayer}
import com.game.rps.reader.InputReader
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification


class PlayerVsPlayerStrategyTest extends Specification with Mockito{

   "Player vs Bot specifications" >> {

     "Player and Bot must play for specified rounds" >> {
        val player1 = spy(new HumanPlayer("hp"))
        val player2 = mock[BotPlayer].smart
        val inputReader = mock[InputReader]
        val out = new ByteArrayOutputStream()

        inputReader.readShape(anyString) returns(SCISSORS, SCISSORS, SCISSORS)
        player2.getMove returns(PAPER, PAPER, PAPER)

       val res = Console.withOut(out){
          new PlayerVsBotStrategy(3, player1 , player2,inputReader).play()
       }
         res.size must_== 3

     }

     "Player and Bot must play for specified rounds and human player wins all" >> {
       val player1 = spy(new HumanPlayer("human player"))
       val player2 = mock[BotPlayer].smart
       val inputReader = mock[InputReader]
       val out = new ByteArrayOutputStream()

       inputReader.readShape(anyString) returns(SCISSORS, SCISSORS, SCISSORS)
       player2.getMove returns(PAPER, PAPER, PAPER)

       val res = Console.withOut(out){
         new PlayerVsBotStrategy(3, player1 , player2,inputReader).play()
       }
       val t = res.last

       t.winner.player.getName must_== "human player"
       t.winner.score must_== 3
       res.size must_== 3

     }
     "Player and Bot must play for specified rounds and human and bot wins some games" >> {
       val player1 = spy(new HumanPlayer("human player"))
       val player2 = mock[BotPlayer].smart
       val inputReader = mock[InputReader]
       val out = new ByteArrayOutputStream()

       inputReader.readShape(anyString) returns(SCISSORS,SCISSORS, ROCK)
       player2.getMove returns(PAPER, PAPER, PAPER)

       val res = Console.withOut(out){
         new PlayerVsBotStrategy(3, player1 , player2,inputReader).play()
       }
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
