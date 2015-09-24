package com.game.rps.core.moves

import com.game.rps.core.random.RandomGenerator
import com.game.rps.model.{GameOrder, Shape}


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
  def generateMove(): Option[T]

}


/**
 * Moves generator for Rock, Paper and Scissors game
 * Give an list of shapes should generate a move
 */
trait RPSMovesGenerate extends MovesGenerator[GameOrder[Shape]] {

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
class RPSMovesGenerator private(m: Seq[GameOrder[Shape]])(implicit rg: RandomGenerator) extends RPSMovesGenerate {
  /**
   * @inheritdoc
   */
  override val randomGenerator: RandomGenerator = rg

  /**
   * @inheritdoc
   * @return
   */
  override def moves: Seq[GameOrder[Shape]] = m
}

/**
 * Helper object to create a singleton RPSMovesgenerator with default
 * random generator
 */
object RPSMovesGenerator {

  // import default random generator as an implicit
  import com.game.rps.core.random.DefaultRandomGenerator.RandomGenerator

  /**
   * Constructor to create RPSMoves generator with default random generator
   * @param m
   * @return
   */
  def apply(m: Seq[GameOrder[Shape]]) = new RPSMovesGenerator(m)

}

