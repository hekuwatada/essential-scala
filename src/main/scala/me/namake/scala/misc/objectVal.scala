package me.namake.scala.misc

object evalObj extends App {
  // object will not be evaluated until it is referenced
  object foo extends LazyObj
}

object evalObj2 extends App {
  object foo extends LazyObj

  foo // foo is now evaluated
}

object evalVal extends App {
  // whereas val will be eagerly evaluated
  val bar = new LazyObj {}
}

sealed trait LazyObj {
  println("lazy obj constructor")
}