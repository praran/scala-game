package com.game.rps.core.movesgenerator

import com.game.rps.core.randomgenerator.RandomGenerator
import com.game.rps.model.GameShapes.Shape


/**
 * Contract to list available moves and generate a next possible move
 * @tparam T
 */
trait MovesGenerator[T] {

  /**
   * List available moves
   * @return
   */
  def moves: Seq[T]

  /**
   * Generate a single move
   * @return
   */
  def generateMove(): T

}


/**
 * Moves generator for Rock, Paper and Scissors game
 * Give an list of shapes should generate a move
 */
trait RPSMovesGenerate extends MovesGenerator[Shape] {

  /**
   * @inheritdoc
   */
  val randomGenerator: RandomGenerator

  /**
   * @inheritdoc
   */
  def generateMove() = {
    randomGenerator.getRandom(moves)
  }

}

/**
 * Rock, Paper and Scissors moves generator
 * @param m
 * @param rg
 */
class RPSMovesGenerator private(m: Seq[Shape])(implicit rg: RandomGenerator) extends RPSMovesGenerate {
  /**
   * @inheritdoc
   */
  override val randomGenerator: RandomGenerator = rg

  /**
   * @inheritdoc
   * @return
   */
  override def moves: Seq[Shape] = m
}

/**
 * Helper object to create a singleton RPSMovesgenerator with default
 * random generator
 */
object RPSMovesGenerator {

  // import default random generator as an implicit
  import com.game.rps.core.randomgenerator.DefaultRandomGenerator.RandomGenerator

  /**
   * Constructor to create RPSMoves generator with default random generator
   * @param m
   * @return
   */
  def apply(m: Seq[Shape]) = new RPSMovesGenerator(m)

}

