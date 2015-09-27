package com.game.rps.utils

import com.game.rps.model.GameShapes
import com.game.rps.model.GameShapes.Shape
import com.game.rps.model.Message._

import scala.io.StdIn.{readInt, readLine}


class ConsoleUtils {


  /**
   * Returns the shape for given input string
   * @param str
   * @return Option[Shape]
   */
  def strToShape(str: String) = GameShapes.allShapes.find(s => s.toString.equalsIgnoreCase(str))


  /**
   * Reads input from standard in and returns the corresponding shape else retry
   * terminate if out of tries
   * @param message
   * @param tries
   * @return
   */
  def readShape(message: String, tries: Int = 3): Option[Shape] = {
    if (tries <= 0) {
      println(OUT_OF_TRIES_TERMINATING)
      return None
    }
    val in = readLine(message)
    strToShape(in) match {
      case None => println(MESS_INVALID_INPUT); readShape(message, tries - 1)
      case s => s
    }
  }

  /**
   * Read string from console
   * @param msg
   * @return
   */
  def readString(msg: String): String = {
    readLine(msg)
  }


  /**
   * Reads integer from std in for given tries
   * @param msg
   * @param tries
   * @return
   */
  def readInteger(msg: String, tries: Int = 3): Option[Int] = {
    if (tries <= 0) {
      println(OUT_OF_TRIES_TERMINATING)
      return None
    }
    println(msg)

    try
      Some(readInt())
    catch {
      case ex: NumberFormatException => println(MESS_INVALID_INPUT); readInteger(msg, tries - 1)
    }


  }
}

/**
 * Singleton helper object
 */
object ConsoleUtils extends ConsoleUtils {}