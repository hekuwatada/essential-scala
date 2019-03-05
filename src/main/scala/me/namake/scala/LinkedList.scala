package me.namake.scala

sealed trait LinkedList[A] {
  /**
    * For an algebraic data type A, fold coverts it to
    * a generic type B
    */
  //TODO: make it tail recursive
  def fold[B](end: B)(f: (A, B) => B): B =
    this match {
      case End() => end
      case Pair(head, tail) => f(head, tail.fold(end)(f))
    }
}

case class End[A]() extends LinkedList[A]
case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]