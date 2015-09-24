package com.game.rps.core

import com.game.rps.Exception.NoAvailableMoveException
import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.model._


/**
  */
object Test {

  def main(args: Array[String]) {


    //import DefaultRandomGenerator._

    val s = Seq[GameOrder[Shape]](ROCK, PAPER, SCISSORS);
    val g =  RPSMovesGenerator(s)

    println(g.generateMove().get)

    val ex = new NoAvailableMoveException("tunne")

    println(ex.getMessage())


  }

}
