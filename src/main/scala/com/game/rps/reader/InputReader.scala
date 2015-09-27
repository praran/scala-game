package com.game.rps.reader

import com.game.rps.model.GameShapes.Shape
import com.game.rps.utils.ConsoleUtils


/**
 * Contract to Read data from input source
 */
trait InputReader {

  /**
   * Read shape
   * @param msg
   * @return
   */
  def readShape(msg: String = ""): Shape

  /**
   * Read name
   * @param msg
   * @return
   */
  def readName(msg: String = ""): String

  /**
   * Read no of rounds
   * @param msg
   * @return
   */
  def readNoOfRound(msg: String = ""): Int
}

/**
 * Console Reader to read from console
 */
class ConsoleReader private(val consoleUtils: ConsoleUtils) extends InputReader {

  /**
   * @inheritdoc
   */
  override def readShape(msg: String): Shape = consoleUtils.readShape(msg).get

  /**
   * @inheritdoc
   */
  override def readNoOfRound(msg: String): Int = consoleUtils.readInteger(msg).get

  /**
   * @inheritdoc
   */
  override def readName(msg: String): String = consoleUtils.readString(msg)
}

object ConsoleReader {

  def apply() = new ConsoleReader(ConsoleUtils)

  def apply(consoleUtils: ConsoleUtils) = new ConsoleReader(consoleUtils)


}