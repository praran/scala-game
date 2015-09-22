package com.game.rps.core

import com.game.rps.model.{ROCK, Shape, GameOrder}

import scala.util.Random


trait MovesGenerator[T]{
  
  var moves:Seq[T]
  
  def generateMove() : T

}



trait RPSMovesGenerate extends MovesGenerator[GameOrder[Shape]]{
  
  implicit val randomGenerator = new Random();
  
  def generateMove():GameOrder[Shape] = {
    randomGenerator.shuffle(moves).head
  }

}


class RPSMovesGenerator(s :Seq[GameOrder[Shape]])( implicit  randomGenerator: Random) extends RPSMovesGenerate{
  
  override var moves: Seq[GameOrder[Shape]] = s
}

