package com.game.rps.core.reader

import com.game.rps.model.GameShapes.ROCK
import com.game.rps.reader.ConsoleReader
import com.game.rps.utils.ConsoleUtils
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class ConsoleReaderTest  extends Specification with Mockito{

  "Console reader specifications" >> {
    "Read shape from console" >> {
       val m = mock[ConsoleUtils]
       m.readShape(any[String], any[Int]) returns(Some(ROCK))
       ConsoleReader(m).readShape("") must_== ROCK

    }

    "Read round no from console" >> {
      val m = mock[ConsoleUtils]
      m.readInteger(any[String], any[Int]) returns(Some(1))
      ConsoleReader(m).readNoOfRound("") must_== 1

    }

    "Read name from console" >> {
      val m = mock[ConsoleUtils]
      m.readString(any[String]) returns("Name")
      ConsoleReader(m).readName("") must_== "Name"
    }
  }

}
