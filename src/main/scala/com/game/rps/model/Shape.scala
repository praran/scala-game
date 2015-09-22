package com.game.rps.model



trait GameOrder[T] {

  def beatenBy(other: GameOrder[T]) : Boolean

}


trait Shape extends GameOrder[Shape]{
   val canBeBeatenBy : Seq[Shape]

  // add comparision feature

  override
   def beatenBy(other : GameOrder[Shape]): Boolean = canBeBeatenBy.contains(other)
}


case object ROCK extends Shape{
  val canBeBeatenBy = Set[Shape](PAPER)
}

case object PAPER extends Shape{
  val canBeBeatenBy = Set[Shape](SCISSORS)
}

case object SCISSORS extends Shape{
  val canBeBeatenBy = Set[Shape](ROCK)
}