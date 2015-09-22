package com.game.rps.player

import com.game.rps.model.{ROCK, Shape, GameOrder}

/**
  */
trait RPSPlayer {
  def getName():String
  
  def getMove():GameOrder[Shape]
}


class Player(name : String) extends RPSPlayer{
  def getName() = this.name;
  
  def getMove() = ROCK;
}