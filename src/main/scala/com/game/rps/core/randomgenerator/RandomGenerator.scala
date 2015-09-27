package com.game.rps.core.randomgenerator


/**
 * Randomness generator
 * Implemented as polymorphic or parametric datatype given a sequence of type should return a single
 * element of same type
 */
trait RandomGenerator {
  /**
   * Of the available input sequence returns an member element
   * @param in
   * @tparam T
   * @return
   */
  def getRandom[T <: AnyRef](in: Seq[T]): T
}


/**
 * A default random generator using $scala.util.Random
 * defined as an object so the object is singleton

 */
object DefaultRandomGenerator {

  /**
   * defined the internal object as implicit so can be used within an implicit context
   */
  implicit object RandomGenerator extends RandomGenerator {

    import scala.util.Random

    /**
     * Simple random object
     */
    val random = new Random()

    /**
     * @inheritdoc
     */
    override def getRandom[T <: AnyRef](in: Seq[T]) = {
      random.shuffle(in).head
    }
  }

}






