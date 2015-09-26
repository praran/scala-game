package com.game.rps.model

import com.game.rps.model.GameShapes.{SCISSORS, PAPER, ROCK}
import org.specs2.mutable.Specification


class ModelTest extends Specification{

  "ROCK game shape specifications" >> {

     "ROCK should be beaten by PAPER" >> {
       ROCK < PAPER must_== true
     }

     "ROCK should not be beaten by Scissors" >> {
       ROCK < SCISSORS must_== false
     }

    "ROCK should not be beaten by ROCK" >> {
      ROCK < ROCK must_== false
    }

  }


  "PAPER game shape specifications" >> {
    "PAPER should be beaten by SCISSORS" >> {
      PAPER < SCISSORS must_== true
    }

    "PAPER should not be beaten by ROCK" >> {
      PAPER < ROCK must_== false
    }

    "PAPER should not be beaten by PAPER" >> {
      PAPER < PAPER must_== false
    }


  }


  "SCISSORS game shape specifications" >> {
    "SCISSORS should be beaten by ROCK" >> {
      SCISSORS < ROCK must_== true
    }

    "SCISSORS should not be beaten by PAPER" >> {
      SCISSORS < PAPER must_== false
    }

    "SCISSORS should not be beaten by SCISSORS" >> {
      SCISSORS < SCISSORS must_== false
    }


  }

}
