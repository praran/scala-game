package com.game.rps

import com.game.rps.strategy.{BotVsBotStrategy, PlayerVsBotStrategy, PlayerVsPlayerStrategy}
import com.game.rps.utils.ConsoleUtils.readInteger

/**
  */
object Runner extends App {


  println("hola !!!!")

  println("**************************\n" +
          "* Rock , Paper, Scissors *\n"+
          "**************************\n"+
  "Choose options and press enter press ctrl + c to terminate\n"+
  "    1 for Bot Vs Bot \n"+
  "    2 for Player Vs Player \n"+
  "    3 for Player Vs Bot \n")

  def run : Unit = readInteger("") match {
    case 1 => new BotVsBotStrategy().play()
    case 2 => new PlayerVsPlayerStrategy().play()
    case 3 => new PlayerVsBotStrategy().play()
    case _ => println("Invalid choice"); run
  }

  run


  // ConsoleUtils.scanInputShape("enter ur move !!!! \n")

  //  ConsoleUtils.readInteger("enter no of rounds")

}
