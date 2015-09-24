package com.game.rps.model


/**
 * Defining a partial order for game
 * @tparam T
 */
trait GameOrder[T] {

  def beatenBy(other: GameOrder[T]): Boolean

}


/**
 * Shapes for the ROCK , PAPER and SCISSORS game
 * implements partial order and also contains a string representation of the shape
 */
trait Shape extends GameOrder[Shape] {

  /**
   * Store the shapes that can beat this shape
   * @return
   */
  protected def canBeBeatenBy: Set[GameOrder[Shape]]

  /**
   * String representation of the shape
   * @return
   */
  protected def stringValue: String

  // add comparision feature

  /**
   * Return if the other shape can beat this shape
   * @param other
   * @return
   */
  override
  def beatenBy(other: GameOrder[Shape]): Boolean = canBeBeatenBy.contains(other)
}


/**
 * A singleton object representing the ROCK shape
 */
case object ROCK extends Shape {
  /**
   * @inheritdoc
   */
  def canBeBeatenBy = Set[GameOrder[Shape]](PAPER)

  /**
   * @inheritdoc
   */
  def stringValue = "ROCK"
}

/**
 * A singleton object representing the PAPER shape
 */
case object PAPER extends Shape {
  /**
   * @inheritdoc
   */
  def canBeBeatenBy = Set[GameOrder[Shape]](SCISSORS)

  /**
   * @inheritdoc
   */
  def stringValue = "PAPER"
}

/**
 * A singleton object representing the SCISSORS shape
 */
case object SCISSORS extends Shape {
  /**
   * @inheritdoc
   */
  def canBeBeatenBy = Set[GameOrder[Shape]](ROCK)

  /**
   * @inheritdoc
   */
  def stringValue = "SCISSORS"
}