package com.game.rps.utils

import java.io.{ByteArrayOutputStream, ByteArrayInputStream}

import com.game.rps.model.GameShapes.ROCK
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import org.specs2.mock.Mockito
import org.specs2.mock.mockito.CalledMatchers.MockitoVerificationWithTimeout
import org.specs2.mock.mockito.MockitoStubs
import org.specs2.mutable.Specification

/**
 * Created by pradeep on 26/09/2015.
 */

class ConsoleUtilsTest extends Specification with Mockito{


  "Read shape specifications" >> {

    "read shape should return shape or return none when invalid input" >> {
      val in = new ByteArrayInputStream("rock".getBytes)
      val shape = Console.withIn(in) {
          ConsoleUtils.readShape("")
      }
      shape.get must_==( ROCK)
    }

    "read shape should quit on invalid input after trying" >> {
      val in = new ByteArrayInputStream("invalid".getBytes)
      val shape = Console.withIn(in) {
        ConsoleUtils.readShape("",1)
      }
      shape must_== None
    }

  }


}
