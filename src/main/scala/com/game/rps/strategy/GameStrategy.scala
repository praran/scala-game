package com.game.rps.strategy

import com.game.rps.core.moves.RPSMovesGenerator
import com.game.rps.core.round.{RPSGame, GameRound}
import com.game.rps.model.GameShapes
import com.game.rps.model.GameShapes.Shape
import com.game.rps.player.{HumanPlayer, BotPlayer, Player}



trait GameStrategy {

  def play()

  def strToShape(str : String):Shape = GameShapes.allShapes.find(s => s.stringValue.equalsIgnoreCase(str)).get

}


class PlayerVsPlayer() extends GameStrategy{

  val  rounds : List[GameRound] = Nil

  println("Enter the number of rounds :")
  val noOfRounds = io.StdIn.readInt()
  println("Enter player1 name :")
  val player1 = new HumanPlayer(io.StdIn.readLine())
  println("Enter player2 name :")
  val player2 = new HumanPlayer(io.StdIn.readLine())

  override def play(): Unit = {
    1 to noOfRounds foreach { i =>
      println("Player 1 move")
      val p1 = io.StdIn.readLine()
      player1.setMove(strToShape(p1))
      println("player 2 move")
      val p2 = io.StdIn.readLine()
      player2.setMove(strToShape(p2))

      val gr = RPSGame.play(i, player1, player2)
      rounds.::(gr)
      println(gr.toString)

    }

    rounds.foreach(r => println(r.toString))

  }

}


class PlayerVsBot() extends GameStrategy{

  implicit val movesGenerator = RPSMovesGenerator(GameShapes.allShapes)
  val  rounds  = Nil

  println("Enter the number of rounds :")
  val noOfRounds = io.StdIn.readInt()
  println("Enter player name :")
  val player1 = new HumanPlayer(io.StdIn.readLine())
  val player2 = new BotPlayer("Hulk")


  override def play(): Unit = {
    1 to noOfRounds foreach { i =>
      println("Player 1 move")
      val p1 = io.StdIn.readLine()
      player1.setMove(strToShape(p1))
      val gr = RPSGame.play(i, player1, player2)
      println(gr.toString)

    }

    rounds.foreach(r => println(r.toString))

  }

}

class BotVsBot() extends GameStrategy{
  implicit val movesGenerator = RPSMovesGenerator(GameShapes.allShapes)
  val  rounds : List[GameRound] = Nil

  println("Enter the number of rounds :")
  val noOfRounds = io.StdIn.readInt()
  val player1 = new BotPlayer("Veronica")
  val player2 = new BotPlayer("Hulk")

  override def play(): Unit = {
    1 to noOfRounds foreach { i =>

      val gr = RPSGame.play(i, player1, player2)
      println(gr.toString)

    }

    rounds.foreach(r => println(r.toString))

  }

}