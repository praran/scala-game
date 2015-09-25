package com.game.rps.player

import com.game.rps.core.moves.RPSMovesGenerate
import com.game.rps.model.GameShapes.Shape
import com.game.rps.model.Result.{Lost, Won, Tie, Outcome}



class BotPlayer(name: String)(implicit rPSMovesGenerate: RPSMovesGenerate) extends Player {


  private var score:Int = 0
  /**
   * @inheritdoc
   */
  override def getName = this.name;

  /**
   * @inheritdoc
   */
  override def getMove = rPSMovesGenerate.generateMove();


  /**
   * @inheritdoc
   */
  override def play(shape : Shape): Outcome = {
    getMove compare  shape
    match {
      case 0 => Tie
      case 1 => Won
      case -1 => Lost
    }
  }

  /**
   * @inheritdoc
   */
  override def setMove(shape : Shape) = ???

  /**
   * @inheritdoc
   */
  override def toString = this.name

  /**
   * @inheritdoc
   */
  override def equals(that: Any): Boolean =
    that match {
      case that: Player => that.isInstanceOf[Player] && toString.equalsIgnoreCase(that.toString)
      case _ => false
    }

  /**
   * Return score for player
   */
  override def getScore: Int = this.score

  /**
   * Set score for player
   * @param score
   */
  override def setScore(score: Int): Unit = this.score = score
}