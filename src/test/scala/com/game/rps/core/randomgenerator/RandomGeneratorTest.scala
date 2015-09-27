package com.game.rps.core.randomgenerator

import org.specs2.matcher.Matcher
import org.specs2.mutable.Specification

import scala.collection.mutable


class RandomGeneratorTest extends Specification{

  // SUT
  val randomGenerator = DefaultRandomGenerator.RandomGenerator

  // Test input sequence
  val in:Seq[String] = Seq("one", "two", "Three")


  "Specifications for Random Generator" >> {


     "when get random from empty sequence should throw exception" >> {
         randomGenerator.getRandom(Seq.empty[AnyRef]) must throwA[NoSuchElementException]
     }

     "when get random from non empty empty should return element of the sequence" >> {
         randomGenerator.getRandom(in) must belongTo(in)
     }

    "randomness of random generator should not have a variance of more than 25%" >> {
         val holder : mutable.HashMap[String, Int] =  mutable.HashMap.empty
         1 to 1000 foreach {i =>
              val e  = randomGenerator.getRandom(in)
              val v = holder.getOrElse(e, 0)
              holder.update(e, v+1)
         }
         testVariance(holder.values.toList)(25) must_== true
    }

  }

  /** ***************************************************
    *      Helper methods
    * ****************************************************/

  /**
   * Matcher to check if the element belongs to the sequence
   * @param in
   * @return
   */
  def belongTo(in : Seq[AnyRef]) : Matcher[AnyRef] = {
       e:AnyRef => (in.contains(e), "Should be an element of input sequence")
  }

  /**
   * Test variance
   * Logic : take average of all occurrences of elements
   *         generate min with avg - (variance factor of average)
   *         generate max with avg + (variance factor of average)
   *         test if each occurrence lies between min and max
   */
  def testVariance(values : List[Int])(varianceFactor : Int):Boolean = {
    if (values.isEmpty) return false
    val av = values.foldLeft(0)(_ + _)/values.size
    val min = av - (av * varianceFactor/100)
    val max = av + (av * varianceFactor/100)
    values.foldLeft(true) ((x,y) => x && y >= min && y <= max)
  }

}

