package com.game.rps.core.round

import com.game.rps.model.GameShapes.ROCK
import com.game.rps.model.Result.{Lost, Tie, Won}
import com.game.rps.model.player.Player
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import com.game.rps.model.GameRoundModel._



class RPSGameRoundPlayTest extends Specification with Mockito{



  "when the player make same move should be a tie and scores should remain unchange" >> {
    // Initialize
    val player1 = mock[Player].smart
    val player2 = mock[Player].smart
    val p1 = new PlayerAndScore(player1, 0)
    val p2 = new PlayerAndScore(player2,0)
    // behaviour
    player2.getMove returns(ROCK)
    player1.play(ROCK) returns(Tie)
    // SUT
    val gameResult = RPSGameRoundPlay.play(new GameRound(1,p1,p2))
    // Assert
    (gameResult.outcome must_== Tie) and
           (gameResult.winner.score must be_==(0)) and
                 (gameResult.looser.score must be_==(0))
    // verification
    there was one(player2).getMove
    there was one(player1).play(ROCK)
  }

  "when the player1 moves rock player2 moves scissors player1 should win and  player1 score should be incremented" >> {
    // Initialize
    val player1 = mock[Player].smart
    val player2 = mock[Player].smart
    val p1 = new PlayerAndScore(player1, 0)
    val p2 = new PlayerAndScore(player2,0)
    // behaviour
    player2.getMove returns(ROCK)
    player1.play(ROCK) returns(Won)
    // SUT
    val gameResult = RPSGameRoundPlay.play(new GameRound(1,p1,p2))
    // Assert
    (gameResult.outcome must_== Won) and
      (gameResult.winner.score must be_==(1)) and
      (gameResult.looser.score must be_==(0))
    // verification
    there was one(player2).getMove
    there was one(player1).play(ROCK)
  }

  "when the player1 moves paper,  player2 moves scissors player2 should win and  player2 score should be incremented" >> {
    // Initialize
    val player1 = mock[Player].smart
    val player2 = mock[Player].smart
    val p1 = new PlayerAndScore(player1, 0)
    val p2 = new PlayerAndScore(player2,0)
    // behaviour
    player2.getMove returns(ROCK)
    player1.play(ROCK) returns(Lost)
    // SUT
    val gameResult = RPSGameRoundPlay.play(new GameRound(1,p1,p2))
    // Assert
    (gameResult.outcome must_== Won) and
      (gameResult.winner.score must be_==(1)) and
      (gameResult.looser.score must be_==(0))
    // verification
    there was one(player2).getMove
    there was one(player1).play(ROCK)
  }


}
