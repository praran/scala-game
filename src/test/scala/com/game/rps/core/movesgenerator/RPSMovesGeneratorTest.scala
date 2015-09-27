package com.game.rps.core.movesgenerator

import com.game.rps.model.GameShapes
import com.game.rps.model.GameShapes.Shape
import org.specs2.mutable.Specification

/**
 * Created by pradeep on 26/09/2015.
 */
class RPSMovesGeneratorTest extends Specification {

  val shapes = GameShapes.allShapes
  // SUT
  val rPSMovesGenerator = RPSMovesGenerator(shapes)


  "Specifications for RPSMovesGenerator" >> {

    "when called moves on empty shapes should return empty" >> {
      RPSMovesGenerator(Seq.empty[Shape]).moves must_== Seq[Shape]()
    }

    "when called generate move on empty shapes should throw exception" >> {
      RPSMovesGenerator(Seq.empty[Shape]).generateMove() must throwA[NoSuchElementException]
    }


    "when called moves should list all moves" >> {
      rPSMovesGenerator.moves must_== shapes
    }

    "when called generate move should list valid move" >> {
      rPSMovesGenerator.generateMove() must belongTo(shapes)

    }


  }

  def belongTo(in: Seq[AnyRef]) = {
    e: AnyRef => (in.contains(e), "Should be an element of input sequence")
  }

}
