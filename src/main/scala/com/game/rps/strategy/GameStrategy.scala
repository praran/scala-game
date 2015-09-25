package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{GameRound, RPSGame}
import com.game.rps.model.GameShapes
import com.game.rps.model.GameShapes.Shape
import com.game.rps.player.{BotPlayer, HumanPlayer}
import io.StdIn.readLine


trait GameStrategy {

  def play()

  def strToShape(str: String): Shape = GameShapes.allShapes.find(s => s.stringValue.equalsIgnoreCase(str)).get

}








