package com.game.rps.player

import com.game.rps.core.moves.RPSMovesGenerate
import com.game.rps.model.{GameOrder, Shape}


/**
 * Trait representing the Player
 * player composed of name and the next available move
 */
trait Player {
  /**
   * Returns the Name of the player
   * @return
   */
  def getName(): String

  /**
   * Returns and option of the next available move
   * @return
   */
  def getMove(): Option[GameOrder[Shape]]

  def isBeatenBy(player : Player): Boolean

}


class RPSPlayer(name: String)(implicit rPSMovesGenerate: RPSMovesGenerate) extends Player {
  /**
   * @inheritdoc
   */
  override def getName() = this.name;

  /**
   * @inheritdoc
   *
   */
  override def getMove() = rPSMovesGenerate.generateMove();


  override def isBeatenBy(player : Player): Boolean = {
       this.getMove().get.beatenBy(player.getMove().get)
  }


  override def toString() ={
     this.name
  }


  def equals(player: RPSPlayer): Boolean={
    this.getName().equalsIgnoreCase(player.getName())
  }

}

