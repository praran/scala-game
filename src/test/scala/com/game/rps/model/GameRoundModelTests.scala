package com.game.rps.model

import com.game.rps.model.GameRoundModel.{GameRound, PlayerAndScore}
import com.game.rps.model.player.HumanPlayer
import org.specs2.mutable.Specification


class GameRoundModelTests extends Specification {

  "Game Round model  tests" >> {

    "Player and score creation" >> {
      val p = new HumanPlayer("human")
      val ps = new PlayerAndScore(p, 0)
      ps.player must_== p
      ps.score must_== 0
    }

    "Game round creation" >> {
      val p = new HumanPlayer("human")
      val p2 = new HumanPlayer("human2")
      val ps1 = new PlayerAndScore(p, 0)
      val ps2 = new PlayerAndScore(p2, 1)
      val gameRound = new GameRound(1, ps1, ps2)
      gameRound.round must_== 1
      gameRound.player1 must_== ps1
      gameRound.player2 must_== ps2
    }
  }
}
