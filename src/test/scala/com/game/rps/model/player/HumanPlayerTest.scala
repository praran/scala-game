package com.game.rps.model.player

import com.game.rps.model.GameShapes.{PAPER, ROCK, SCISSORS}
import com.game.rps.model.Result.{Lost, Tie, Won}
import org.specs2.mutable.Specification


class HumanPlayerTest extends Specification {


  "Specifications for Human Player" >> {

    "Human player getname should return name" >> {
      val player = new HumanPlayer("human")
      player.getName must_== "human"
    }

    "Human player should be able to generate move" >> {
      val player = new HumanPlayer("human")
      player.setMove(ROCK)
      player.getMove must_== ROCK
    }


    "Human player should be able to set move" >> {
      val player = new HumanPlayer("human")
      player.setMove(ROCK)
      player.getMove must_== ROCK
    }

    "Human player rock against shape scissors should Win" >> {
      val player = new HumanPlayer("human")
      player.setMove(ROCK)
      player.play(SCISSORS) must_== Won
    }

    "Human player rock against shape rock should Tie" >> {
      val player = new HumanPlayer("human")
      player.setMove(ROCK)
      player.play(ROCK) must_== Tie
    }


    "Human player rock against shape paper should Loose" >> {
      val player = new HumanPlayer("human")
      player.setMove(ROCK)
      player.play(PAPER) must_== Lost
    }

  }
}
