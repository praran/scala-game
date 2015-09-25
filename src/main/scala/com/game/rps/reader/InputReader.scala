package com.game.rps.reader

import com.game.rps.model.GameShapes.Shape
import com.game.rps.utils.ConsoleUtils


/**
 * Read data from input
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
object ConsoleReader extends InputReader {
  /**
   * @inheritdoc
   */
  override def readShape(msg: String): Shape = ConsoleUtils.readShape(msg)

  /**
   * @inheritdoc
   */
  override def readNoOfRound(msg: String): Int = ConsoleUtils.readInteger(msg)

  /**
   * @inheritdoc
   */
  override def readName(msg: String): String = ConsoleUtils.readString(msg)
}