package com.game.rps.core

import com.game.rps.strategy.{BotVsBotStrategy, PlayerVsBotStrategy, PlayerVsPlayerStrategy}

/**
  */
object Runner extends App {


  println("hola !!!!")

  println("Rock , Paper, Scissors")
  println("Choose options and press enter")
  println("    1 for Bot Vs Bot")
  println("    2 for Player Vs Player")
  println("    3 for Player Vs Bot")
  io.StdIn.readInt() match {
    case 1 => new BotVsBotStrategy().play()
    case 2 => new PlayerVsPlayerStrategy().play()
    case 3 => new PlayerVsBotStrategy().play()
  }

  // ConsoleUtils.scanInputShape("enter ur move !!!! \n")

  //  ConsoleUtils.readInteger("enter no of rounds")

}
