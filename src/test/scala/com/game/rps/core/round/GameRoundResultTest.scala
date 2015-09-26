package com.game.rps.core.round

import com.game.rps.model.Result.{Tie, Won}
import com.game.rps.player.HumanPlayer
import org.specs2.mutable.Specification


class GameRoundResultTest extends  Specification{

   "Specifications for GameRoundResult" >> {
         val player1 = new HumanPlayer("one")
         val player2 = new HumanPlayer("two")
         val p1 = new PlayerAndScore(player1, 1)
         val p2 = new PlayerAndScore(player2, 0)
         val tieString = s"Round 1 : Tie \n   ${p1.player.getName} Score : ${p1.score} \n     ${p2.player.getName} Score : ${p2.score} \n "
         val notTieString = s"Round 1 \n    Winner : ${p1.player.getName} Score : ${p1.score} \n    Looser : ${p2.player.getName} Score : ${p2.score} \n"

      "GameRound result when tie should resolve to tie String" >> {
             new GameRoundResult(1, Tie, p1, p2).toString must_== tieString
        }

      "GameRound result when not tie should resolve to  not tie String" >> {
         new GameRoundResult(1, Won, p1, p2).toString must_== notTieString
      }
   }
}
