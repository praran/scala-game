package com.game.rps.utils

import java.io.BufferedReader

import com.game.rps.model.{Message, GameShapes}
import com.game.rps.model.GameShapes.Shape

import scala.annotation.tailrec
import scala.io.StdIn
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import Message._



object ConsoleUtils{



  /**
   * Returns the shape for given input string
   * @param str
   * @return Option[Shape]
   */
  def strToShape(str: String) = GameShapes.allShapes.find(s => s.stringValue.equalsIgnoreCase(str))


  /**
   * Reads input from standard in and returns the corresponding shape else retry
   * terminate if out of tries
   * @param message
   * @param tries
   * @return
   */
  @tailrec
  def readShape(message:String, tries : Int = 3): Option[Shape] = {
    if(tries <=0) {
      println(OUT_OF_TRIES_TERMINATING)
      return None
    }
    val in = readLine(message)
    strToShape(in) match {
      case None    => println(MESS_INVALID_INPUT); readShape(message, tries-1)
      case s       =>  s
    }
  }

  /**
   * Read string from console
   * @param msg
   * @return
   */
  def readString(msg:String):String = {
     readLine(msg)
  }


  /**
   * Reads integer from std in for given tries
   * @param msg
   * @param tries
   * @return
   */
  def readInteger(msg : String , tries : Int = 3) : Int = {
     if(tries <=0){
       println(OUT_OF_TRIES_TERMINATING)
       System.exit(1)
     }
      println(msg)

    try
       readInt()
    catch{
      case  ex: NumberFormatException => println(MESS_INVALID_INPUT); readInteger(msg, tries-1)
    }


  }
}