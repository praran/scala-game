package com.game.rps.model.player

import com.game.rps.core.movesgenerator.RPSMovesGenerator
import com.game.rps.model.GameShapes.{PAPER, ROCK, SCISSORS}
import com.game.rps.model.Result.{Lost, Tie, Won}
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification


class BotPlayerTest extends Specification with Mockito {

  "Specifications for Bot Player" >> {

    "Bot player getname should return name" >> {
      val mGenerator = mock[RPSMovesGenerator]
      val botPlayer = new BotPlayer("bot1")(mGenerator)
      botPlayer.getName must_== "bot1"
    }

    "Bot player should be able to generate move" >> {
      val mGenerator = mock[RPSMovesGenerator]
      val botPlayer = new BotPlayer("bot1")(mGenerator)
      mGenerator.generateMove() returns (ROCK)
      botPlayer.getMove must_== ROCK
    }

    "Bot player set move should throw exception" >> {
      val mGenerator = mock[RPSMovesGenerator]
      val botPlayer = new BotPlayer("bot1")(mGenerator)
      botPlayer.setMove(ROCK) must throwA[UnsupportedOperationException]
    }

    "Bot player rock against shape scissors should Win" >> {
      val mGenerator = mock[RPSMovesGenerator]
      val botPlayer = new BotPlayer("bot1")(mGenerator)
      mGenerator.generateMove() returns (ROCK)
      botPlayer.play(SCISSORS) must_== Won
    }

    "Bot player rock against shape rock should Tie" >> {
      val mGenerator = mock[RPSMovesGenerator]
      val botPlayer = new BotPlayer("bot1")(mGenerator)
      mGenerator.generateMove() returns (ROCK)
      botPlayer.play(ROCK) must_== Tie
    }


    "Bot player rock against paper  should Loose" >> {
      val mGenerator = mock[RPSMovesGenerator]
      val botPlayer = new BotPlayer("bot1")(mGenerator)
      mGenerator.generateMove() returns (ROCK)
      botPlayer.play(PAPER) must_== Lost
    }

  }

}
