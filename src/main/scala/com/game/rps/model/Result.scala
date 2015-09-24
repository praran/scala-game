package com.game.rps.model

/**
 * Created by pradeep on 24/09/2015.
 */
object Result {

  sealed trait Outcome

  case object Won extends Outcome
  case object Lost extends Outcome
  case object Tie extends Outcome

}
