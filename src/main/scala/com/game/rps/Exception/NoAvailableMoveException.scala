package com.game.rps.Exception



class NoAvailableMoveException private(ex: RuntimeException) extends RuntimeException {
  def this(message:String) = this(new RuntimeException(message))
  def this(message:String, throwable: Throwable) = this(new RuntimeException(message, throwable))
}

object NoAvailableMoveException {
  def apply(message:String ) = new NoAvailableMoveException(message)
  def apply(message:String , throwable: Throwable) = new NoAvailableMoveException(message, throwable)
}