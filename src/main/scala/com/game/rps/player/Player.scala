package com.game.rps.player

import com.game.rps.model.GameShapes.Shape
import com.game.rps.model.Result.Outcome

/**
 * Trait representing the Player
 * player composed of name and the next available move
 */
trait Player {
  /**
   * Returns the Name of the player
   * @return
   */
  def getName: String

  /**
   * Returns and option of the next available move
   * @return
   */
  def getMove: Shape

  /**
   * Set move for the player
   * @param shape
   */
  def setMove(shape : Shape)

  /**
   * Play against a shape
   * @param shape
   * @return Outcome
   */
  def play(shape : Shape): Outcome

  /**
   * Return score for player
   */
  def getScore: Int


  /**
   * Set score for player
   * @param score
   */
  def setScore(score:Int)

}





