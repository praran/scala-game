package com.game.rps.core

import com.game.rps.model._

/**
  */
object Test {

  def main(args: Array[String]) {

    val s = Seq[GameOrder[Shape]](ROCK, PAPER, SCISSORS);
    val g = new RPSMovesGenerator(s);

   println(g.generateMove())

  }

}
