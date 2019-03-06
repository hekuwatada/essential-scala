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

  /**
    * Example to highlight that complier can infer type once per parameter list.
    * It cannot therefore infer type B for f after B for end.
    */
  def fold2[B](end: B, f: (A, B) => B): B =
    this match {
      case End() => end
      case Pair(head, tail) => f(head, tail.fold2(end, f))
    }

  //TODO: make it tail recursive
  def map[B](f: A => B): LinkedList[B] =
    this match {
      case End() => End[B]()
      case Pair(head, tail) => Pair(f(head), tail.map(f))
    }
}

//TODO: re-implement methods for IntList as LinkedList[Int]
final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]