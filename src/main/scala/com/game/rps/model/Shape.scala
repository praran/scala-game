package com.game.rps.model


object GameShapes {

  /**
   * Shapes for the ROCK , PAPER and SCISSORS game
   * implements partial order and also contains a string representation of the shape
   */
  sealed trait Shape extends Ordered[Shape] {

    /**
     * Store the shapes that can beat this shape
     * @return
     */
    protected def canBeBeatenBy: Set[Shape]

    def stringValue: String

    // add comparision feature

    override def compare(that: Shape) = {

      if (that.toString.equals(this.toString)) 0
      else if (this.canBeBeatenBy.contains(that)) -1
      else 1
    }
  }


  /**
   * A singleton object representing the ROCK shape
   */
  case object ROCK extends Shape {
    /**
     * @inheritdoc
     */
    def canBeBeatenBy = Set[Shape](PAPER)

    /**
     * @inheritdoc
     */
    override def toString = "ROCK"


    override def stringValue: String = toString
  }

  /**
   * A singleton object representing the PAPER shape
   */
  case object PAPER extends Shape {
    /**
     * @inheritdoc
     */
    def canBeBeatenBy = Set[Shape](SCISSORS)

    /**
     * @inheritdoc
     */
    override def toString = "PAPER"

    override def stringValue: String = toString
  }

  /**
   * A singleton object representing the SCISSORS shape
   */
  case object SCISSORS extends Shape {
    /**
     * @inheritdoc
     */
    def canBeBeatenBy = Set[Shape](ROCK)

    /**
     * @inheritdoc
     */
    override def toString = "SCISSORS"

    override def stringValue: String = toString
  }


  def allShapes: Seq[Shape] = Seq(ROCK, SCISSORS, PAPER)

}