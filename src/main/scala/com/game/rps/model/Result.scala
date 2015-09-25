package com.game.rps.model


/**
 * Result of the games
 */
object Result {

  sealed trait Outcome

  /**
   * The case objects define the possible outcomes
   */
  case object Won extends Outcome{
     override  def toString = "Won"
  }

  case object Lost extends Outcome{
    override  def toString = "Lost"
  }

  case object Tie extends Outcome{
    override  def toString = "Tie"
  }

}
