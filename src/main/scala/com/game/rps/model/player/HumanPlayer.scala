package com.game.rps.model.player

import com.game.rps.model.GameShapes.Shape
import com.game.rps.model.Result.{Lost, Outcome, Tie, Won}

class HumanPlayer(name: String) extends Player {

  private var move: Shape = null
  private var score = 0

  /**
   * @inheritdoc
   */
  override def getName = this.name

  /**
   * @inheritdoc
   */
  override def play(shape: Shape): Outcome = {
    getMove compare shape
    match {
      case 0 => Tie
      case 1 => Won
      case -1 => Lost
    }
  }

  /**
   * @inheritdoc
   */
  override def getMove = this.move

  /**
   * @inheritdoc
   */
  override def setMove(shape: Shape) = this.move = shape

  /**
   * @inheritdoc
   */
  override def equals(that: Any): Boolean =
    that match {
      case that: Player => that.isInstanceOf[Player] && toString.equalsIgnoreCase(that.toString)
      case _ => false
    }

  /**
   * @inheritdoc
   */
  override def toString = this.name

}